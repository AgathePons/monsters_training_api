package my_little_monsters;

import my_little_monsters.dto.CapacityDto;
import my_little_monsters.service.impl.CapacityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("api/capacities")
public class CapacityController {

    @Autowired // DI
    private CapacityServiceImpl capacityService;

    @GetMapping
    public Set<CapacityDto> getAll() {
        return capacityService.findAll();
    }
}
