package me.brimon.cloud.miniarch.client;

import me.brimon.cloud.miniarch.dto.ListingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "listing-service", url = "${my.config.nextService}")
public interface ListingClient {
    @GetMapping("/listing/{id}")
    public ListingDTO getListing(@PathVariable("id") Integer id);

    @PostMapping("/listing")
    public void updateListing(@RequestBody ListingDTO listing);
}
