package com.garrybest.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @GetMapping("/")
    public String home() {
        return "<a href='showAllServiceIds'>Show All Service Ids</a>";
    }

    @ResponseBody
    @GetMapping("/showAllServiceIds")
    public String showAllServiceIds() {
        List<String> serviceIds = this.discoveryClient.getServices();

        if (serviceIds == null || serviceIds.isEmpty()) {
            return "No services found!";
        }
        StringBuilder html = new StringBuilder("<h3>Service Ids:</h3>");
        for (String serviceId : serviceIds) {
            html.append("<br><a href='showService?serviceId=").append(serviceId).append("'>").append(serviceId).append("</a>");
        }
        return html.toString();
    }

    @ResponseBody
    @GetMapping("/showService")
    public String showFirstService(@RequestParam(defaultValue = "") String serviceId) {
        // (Need!!) eureka.client.fetchRegistry=true
        List<ServiceInstance> instances = this.discoveryClient.getInstances(serviceId);

        if (instances == null || instances.isEmpty()) {
            return "No instances for service: " + serviceId;
        }
        StringBuilder html = new StringBuilder("<h2>Instances for Service Id: " + serviceId + "</h2>");

        for (ServiceInstance serviceInstance : instances) {
            html.append("<h3>Instance: ").append(serviceInstance.getUri()).append("</h3>");
            html.append("Host: ").append(serviceInstance.getHost()).append("<br>");
            html.append("Port: ").append(serviceInstance.getPort()).append("<br>");
        }

        return html.toString();
    }

    // A REST method, To call from another service.
    // See in Lesson "Load Balancing with Ribbon".
    @ResponseBody
    @GetMapping("/hi")
    public String hello(@RequestParam String name) {
        return "<html>Hi " + name + ", I am from DEMO-SERVICE: " + port + "</html>";
    }
}
