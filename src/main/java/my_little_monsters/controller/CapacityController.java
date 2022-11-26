package my_little_monsters.controller;

import my_little_monsters.dto.CapacityDto;
import my_little_monsters.service.impl.CapacityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
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

    @GetMapping("{id}")
    public CapacityDto getById(@PathVariable("id") int id) {
        Optional<CapacityDto> optCapacity = capacityService.findById(id);
        return optCapacity.get();
    }

    @GetMapping("search")
    public Set<CapacityDto> searchQuery(
            @RequestParam(name="n", required = false) String name,
            @RequestParam(name="at", required = false) Integer attackValue,
            @RequestParam(name="de", required = false) Integer defenseValue
    ) {
        return capacityService.searchQuery(name, attackValue, defenseValue);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CapacityDto add(@RequestBody CapacityDto capacityDto) {
        return capacityService.add(capacityDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean removeById(@PathVariable("id") int id) {
        boolean isExisting = capacityService.delete(id);
        if (isExisting) {
            return true;
        } else {
            return false;
        }
    }

    @PutMapping("{id}")
    public CapacityDto updatePartialById(
            @PathVariable("id") int id,
            @RequestBody CapacityDto updatedCapacity
    ) {
        return updatedCapacity;
    }

}
