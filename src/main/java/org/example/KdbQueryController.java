package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KdbQueryController {

    private final KdbQueryAPI kdbQueryAPI;

    @Autowired
    public KdbQueryController(KdbQueryAPI kdbQueryAPI) {
        this.kdbQueryAPI = kdbQueryAPI;
    }

    @GetMapping("/query")
    public ResponseEntity<List<String[]>> executeQuery(
            @RequestParam(required = false) String date,
            @RequestParam(required = false) String venue,
            @RequestParam(required = false) String messageType) {

        List<String[]> results = kdbQueryAPI.executeQuery(date, venue, messageType);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
