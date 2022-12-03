package my_little_monsters.controller;

import my_little_monsters.dto.CapacityDto;
import my_little_monsters.entities.Capacity;
import my_little_monsters.error.NoDataFoundError;
import my_little_monsters.service.impl.CapacityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/capacities")
public class CapacityController {

    static final String ITEM_TYPE = "Capacity";
    @Autowired // DI
    private CapacityServiceImpl capacityService;

    @GetMapping
    public Iterable<Capacity> getAll() {
        return capacityService.findAll();
    }

    @GetMapping("{id}")
    public Capacity getById(@PathVariable("id") int id) {
        Optional<Capacity> optCapacity = capacityService.findById(id);
        if (optCapacity.isPresent()) {
            return optCapacity.get();
        } else {
            throw NoDataFoundError.withId(ITEM_TYPE, id);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Capacity add(@RequestBody CapacityDto capacityDto) {
        return capacityService.add(capacityDto);
    }

    @PutMapping("{id}")
    public Capacity updatePartialById(
            @PathVariable("id") int id,
            @RequestBody CapacityDto capacityDto
    ) {
        return capacityService.update(capacityDto)
                .orElseThrow(() -> NoDataFoundError.withId(ITEM_TYPE, capacityDto.getId()));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeById(@PathVariable("id") int id) {
        if(!capacityService.delete(id)) {
            throw NoDataFoundError.withId(ITEM_TYPE, id);
        }
    }

    @GetMapping("search")
    public Iterable<Capacity> searchQuery(
            @RequestParam(name="n", required = false) String name,
            @RequestParam(name="at", required = false) Integer attackValue,
            @RequestParam(name="de", required = false) Integer defenseValue
    ) {
        // TODO
        return capacityService.searchQuery(name, attackValue, defenseValue);
    }

}
