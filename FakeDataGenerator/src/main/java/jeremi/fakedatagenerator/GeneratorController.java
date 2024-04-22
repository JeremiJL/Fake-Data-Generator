package jeremi.fakedatagenerator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class GeneratorController {

    private final GeneratorService generatorService;

    public GeneratorController(GeneratorService generatorService) {
        this.generatorService = generatorService;
    }

    private void populateFormOptions(Model model){
        model.addAttribute("languagesList", generatorService.getLanguagesList());
        model.addAttribute("additional_fields_list", generatorService.getAdditionalFieldsList());
    }

    /** Initial view of wab page **/
    @GetMapping(value = "/generator")
    public String showGenerator(Model model){
        populateFormOptions(model);
        return "generator";
    }

    /** View of wab page after submitting form **/
    @PostMapping (value = "/generator")
    public String resultOfGenerator(@RequestParam Integer number_of_entries, @RequestParam(name = "languages") String language, @RequestParam(required = false,defaultValue = "") String[] additional_fields, Model model){
        populateFormOptions(model);
        model.addAttribute("persons", generatorService.generatePersons(number_of_entries,language, List.of(additional_fields)));

        System.out.println("num of entries: "+number_of_entries);
        System.out.println("language: "+language);
        System.out.print("additional fields: ");
        Arrays.stream(additional_fields).forEach(s -> System.out.print(s + ","));

        return "generator";
    }




}
