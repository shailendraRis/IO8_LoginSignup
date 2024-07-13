package com.realnet.Builders.Services;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.realnet.Builders.Entity.Builder_entity_t;
import com.realnet.Builders.Repos.BuilderRepository;
import com.realnet.Dashboard1.Entity.Dashbord1_Line;
import com.realnet.Dashboard1.Entity.Dashbord_Header;
import com.realnet.Dashboard1.Repository.Dashboard_lineRepository;
import com.realnet.Dashboard1.Service.HeaderService;
import com.realnet.api_registery.Entity.Api_registery_header;
import com.realnet.api_registery.Entity.Api_registery_line;
import com.realnet.api_registery.Services.Api_registery_headerService;
import com.realnet.api_registery.Services.Api_registery_lineService;
import com.realnet.fnd.entity1.MenuDet;
import com.realnet.fnd.service1.SecmenuDetailService;

@Service
public class BuilderService {

	@Autowired
	private SecmenuDetailService secmenuDetailService;

	@Autowired
	private HeaderService headerService;

	@Autowired
	private Dashboard_lineRepository dashboard_lineRepository;

	@Autowired
	private Api_registery_headerService api_registery_headerService;

	@Autowired
	private Api_registery_lineService api_registery_lineService;

	@Autowired
	private BuilderRepository builderRepository;

	public void callotherService() {

		// ADD OTHER SERVICE
addCustomMenu( "FeedBack_Formt",  "Transcations"); 


		addCustomMenu("Test2", "Transcations");

		System.out.println("dashboard and menu inserted...");

	}

//	add Custom sec menu detail

	public ResponseEntity<?> addCustomMenu(String tableName, String MenuType) {

//		default menu that is Transcation
		Long menuid = 1577l;

		if (MenuType.equalsIgnoreCase("Masters")) {
			menuid = 1601l;

		}

		MenuDet menuDet = null;
		Builder_entity_t entity_t = builderRepository.findByjobTypeAndName(tableName, "Menu");

		if (entity_t == null) {
			System.out.println("now inserting menu");

			menuDet = secmenuDetailService.customsecmenuadd(tableName, menuid);

			savebuilderentity(tableName, "Menu");
		} else {
			System.out.println(tableName + " menu already have");

		}

		return new ResponseEntity<>(menuDet, HttpStatus.CREATED);
	}

//	add dashboard
	public Dashbord_Header SaveDashboard(String dashboardname, String description, String model) {

		Dashbord_Header dash = null;
		Builder_entity_t entity_t = builderRepository.findByjobTypeAndName(dashboardname, "Dashboard");

		if (entity_t == null) {
			System.out.println("now inserting dashboard");

			Dashbord_Header dashbord_Header = new Dashbord_Header();
			dashbord_Header.setDashboard_name(dashboardname);
			dashbord_Header.setDescription(description);
			dashbord_Header.setObject_type("form");
			dashbord_Header.setSub_object_type("only header");

			dash = headerService.Savedata(dashbord_Header);
			Dashbord1_Line line = new Dashbord1_Line();

			line.setModel(model);
			line.setHeader_id(dash.getId().toString());
			line.setDashbord_Header(dash);
			dashboard_lineRepository.save(line);

			savebuilderentity(dashboardname, "Dashboard");

		} else {
			System.out.println(dashboardname + " dashboard already have");

		}

		return dash;
	}

//	Add to api Registery

	public Api_registery_header SaveApiRegistery(String tableName) {

		Api_registery_header save = null;
		Builder_entity_t entity_t = builderRepository.findByjobTypeAndName(tableName, "Api_registery");

		if (entity_t == null) {
			System.out.println("now inserting apiregistery");

			Api_registery_header api_registery_header = new Api_registery_header();

			api_registery_header.setTable_name(tableName);

			save = api_registery_headerService.Savedata(api_registery_header);

			HashMap<String, String> hashMap = new HashMap<>();

			hashMap.put("GetAll", "/" + tableName + "/" + tableName);
			hashMap.put("GetById", "/" + tableName + "/" + tableName + "{Id}");
			hashMap.put("Post", "/" + tableName + "/" + tableName);
			hashMap.put("Put", "/" + tableName + "/" + tableName);

			Set<Entry<String, String>> entrySet = hashMap.entrySet();

			for (Entry<String, String> entry : entrySet) {

				String Method = entry.getKey();
				String url = entry.getValue();

				Api_registery_line registery_line = new Api_registery_line();

				registery_line.setMethod(Method);
				registery_line.setUrl(url);
				registery_line.setHeader_id(save.getId());

				api_registery_lineService.Savedata(registery_line);

			}

			savebuilderentity(tableName, "Api_registery");
		} else {
			System.out.println(tableName + " all method already have");

		}

		return save;
	}

	private void savebuilderentity(String Job_name, String jobType) {

		Builder_entity_t builder_entity_t = new Builder_entity_t();

		builder_entity_t.setJob_name(Job_name);
		builder_entity_t.setJob_type(jobType);
		builderRepository.save(builder_entity_t);

	}

}