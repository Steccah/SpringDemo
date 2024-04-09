package rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {
    int count = 0;
    @GetMapping("/counter")
    public int counter(@RequestParam(value = "count", defaultValue = "null") String count, @RequestParam(value = "reset", defaultValue = "null") String reset){
        if(!count.equals("null")){
            this.count = Integer.parseInt(count);
        }else {
            this.count++;
        }
        if(!reset.equals("null")){
            this.count = 0;
        }
        return this.count;
    }
}