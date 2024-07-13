package com.realnet.shailendra.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GiteaService {

	@Value("${gitea.token}")
    private String giteaToken;

    @Value("${gitea.api.url}")
    private String giteaApiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<String> updateRepositoryName(String owner, String repo, String newName) {
        String url = String.format("%s/repos/%s/%s", giteaApiUrl, owner, repo);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token " + giteaToken);
        headers.set("Content-Type", "application/json");

        String requestBody = String.format("{\"name\":\"%s\"}", newName);
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        return restTemplate.exchange(url, HttpMethod.PATCH, entity, String.class);
    }

    public ResponseEntity<String> deleteRepository(String owner, String repo) {
        String url = String.format("%s/repos/%s/%s", giteaApiUrl, owner, repo);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token " + giteaToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
    }
	
}





//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class GiteaService {
//    @Value("${gitea.api.url}")
//    private String giteaApiUrl;
//
//    @Value("${gitea.api.token}")
//    private String giteaApiToken;
//
//    private RestTemplate restTemplate = new RestTemplate();
//
//    public void editRepositoryName(Long repoId, String newRepoName) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", "Bearer " + giteaApiToken);
//        headers.set("Content-Type", "application/json");
//
//        String url = giteaApiUrl + "/repos/" + repoId;
//        HttpEntity<String> request = new HttpEntity<>("{\"name\":\"" + newRepoName + "\"}", headers);
//
//        restTemplate.exchange(url, HttpMethod.PATCH, request, String.class);
//    }
//
//    public void deleteRepository(Long repoId) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", "Bearer " + giteaApiToken);
//
//        String url = giteaApiUrl + "/repos/" + repoId;
//        restTemplate.exchange(url, HttpMethod.DELETE, new HttpEntity<>(headers), String.class);
//    }
//}
