package com.realnet.FabricIcardLines.Controllers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.realnet.FabricIcardLines.Entity.FabricIcardLines;
import com.realnet.FabricIcardLines.Services.FabricIcardLinesService;
import com.realnet.suktest.Entity.Test1;
import com.realnet.suktest.Repository.Test1Repository;

@RestController
@RequestMapping("/FabricIcardLines")
public class XmlReplacementController {

	@Autowired
	private Test1Repository studentRepository;

	@Autowired
	private FabricIcardLinesService fabricIcardLinesService;

	@GetMapping("/generateXml/{studentId}/{Cardheader_id}")
	public ResponseEntity<String> generateXml(@PathVariable Integer studentId, @PathVariable String Cardheader_id)
			throws Exception {
		// Fetch student data
		Optional<Test1> optionalStudent = studentRepository.findById(studentId);
		if (!optionalStudent.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Test1 student = optionalStudent.get();

		// Fetch card mapping data
		FabricIcardLines card = fabricIcardLinesService.getbyheaderid(Cardheader_id);

		String mappingKey = card.getMapping_model();

		HashMap<String, String> recordMap = getStudentValue(student, mappingKey);

		String cardXml = fabricIcardLinesService.readjson(Cardheader_id);

		// Fetch XML template based on path from card object
		String xmlTemplate = fetchXmlTemplate(cardXml, recordMap); // Implement this method

		byte[] convertXmlToImage = convertXmlToImage(xmlTemplate);
		String saveImage = saveImage(convertXmlToImage);

		return ResponseEntity.ok().body("Image saved as: " + saveImage);

	}

	private String fetchXmlTemplate(String cardXml, HashMap<String, String> recordMap) {

		for (Entry<String, String> ent : recordMap.entrySet()) {

			String key = ent.getKey();
			String value = ent.getValue();

			cardXml = cardXml.replaceAll(key, value);

		}

		// TODO Auto-generated method stub
		return cardXml;
	}

	// Helper method to get student value based on mapping key

	private HashMap<String, String> getStudentValue(Test1 student, String mappingKey) {
		HashMap<String, String> valuesMap = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode stuNode;
		try {
			stuNode = mapper.readTree(student.toString());
		} catch (IOException e) {
			// Handle JSON parsing exception
			e.printStackTrace();
			return null;
		}

		// Define the mappings between mapping keys and card keys
		JsonNode mappingsNode;
		try {
			mappingsNode = mapper.readTree(mappingKey);
		} catch (IOException e) {
			// Handle JSON parsing exception for mappings
			e.printStackTrace();
			return null;
		}

		// Iterate over the mappings array
		for (JsonNode mappingNode : mappingsNode) {
			String mappingKeyFromNode = mappingNode.get("mapping key").asText();
			String cardKey = mappingNode.get("card key").asText();

			// If it matches, retrieve the corresponding value from the student object
			String value = getValueFromJsonNode(stuNode, mappingKeyFromNode); // Implement this method to extract value
																				// from JSON
			if (value != null) {
				// Add cardKey and value to the valuesMap
				valuesMap.put(cardKey, value);
			}

		}
		return valuesMap;
	}

	// Helper method to extract value from JsonNode based on field name
	private String getValueFromJsonNode(JsonNode stuNode, String fieldName) {
		Iterator<Map.Entry<String, JsonNode>> fieldsIterator = stuNode.fields();
		while (fieldsIterator.hasNext()) {
			Map.Entry<String, JsonNode> fieldEntry = fieldsIterator.next();
			String key = fieldEntry.getKey();
			JsonNode valueNode = fieldEntry.getValue();
			if (key.equals(fieldName)) {
				return valueNode.asText();
			}
		}
		// If fieldName is not found in stuNode
		return null;
	}

	private byte[] convertXmlToImage(String xmlContent) throws TranscoderException {
		// Create PNG transcoder
		Transcoder transcoder = new PNGTranscoder();

		// Set input
		TranscoderInput input = new TranscoderInput(new ByteArrayInputStream(xmlContent.getBytes()));

		// Set output
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		TranscoderOutput output = new TranscoderOutput(outputStream);

		// Perform transcoding
		transcoder.transcode(input, output);
		System.out.println(" converstion happened \n");

		return outputStream.toByteArray();
	}

	private String saveImage(byte[] imageData) throws Exception {

		String fileName = "image_" + System.currentTimeMillis() + ".png";

		Path filePath = Paths.get(fileName);
		FileOutputStream fos = new FileOutputStream(filePath.toString());
		fos.write(imageData);
		fos.close();

		return filePath.toString();
	}
}
