package ua.com.feiron.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.com.feiron.domain.Pn;
import ua.com.feiron.repository.PnRepository;
import ua.com.feiron.validation.PnValidator;

import java.util.List;

@Controller
public class PnController {

    private PnRepository pnRepository;
    private PnValidator pnValidator;

    @Autowired
    public PnController(PnRepository pnRepository, PnValidator pnValidator){
        this.pnRepository = pnRepository;
        this.pnValidator = pnValidator;

    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getPr(){
        return "index";
    }

    @RequestMapping(value = "product", method = RequestMethod.GET)
    public String getProduct(Model model){
        List<Pn> lists = this.pnRepository.listAll();
        model.addAttribute("lists", lists);
        return "product";
    }
    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public String addProduct(Model model){
        model.addAttribute("pn", new Pn());
        return "addProduct";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public String addProduct(@ModelAttribute("pn") Pn pn, BindingResult bindingResult){
        this.pnValidator.validate(pn, bindingResult);
        if (bindingResult.hasErrors()){
            return "addProduct";
        }

        this.pnRepository.addProduct(pn);
        return "redirect:/product";
    }

    @RequestMapping(value = "deleteProduct/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('admin')")
    public String deleteProduct(@PathVariable Integer id){

        this.pnRepository.removeProduct(id);
        return "redirect:/product";
    }
//    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
//    public void getEdit(@RequestParam(value = "id", required = true) Integer id, Model model){
//
//        model.addAttribute("profnastilAtribute", id);
//    }

    @RequestMapping(value = "calc", method = RequestMethod.GET)
    public ModelMap say(@ModelAttribute("pn")Pn pn, ModelMap modelMap){
        modelMap = new ModelMap();
        if (pn.getA() != null && pn.getB() != null && pn.getWork_b() != null && pn.getBase_b() != null ){
            modelMap.addAttribute("a", pn.getA());
            modelMap.addAttribute("b", pn.getB());
            modelMap.addAttribute("work_B", pn.getWork_b());
            modelMap.addAttribute("bas_B", pn.getBase_b());
            modelMap.addAttribute("result", ((Math.ceil(pn.getB() / pn.getWork_b())) * pn.getA() * pn.getBase_b()));
            modelMap.addAttribute("sam", (int)((pn.getB() / pn.getWork_b()) * pn.getA() * pn.getBase_b() * 6));
            modelMap.addAttribute("kl",(int)(Math.ceil(pn.getB() / pn.getWork_b())));

        }else {
            modelMap.addAttribute("result",  "" );
        }
        return modelMap;
    }

    @RequestMapping(value = "calc1", method = RequestMethod.GET)
    public ModelMap twoSk(@RequestParam(required = false) Double work_B, @RequestParam(required = false) Double bas_B,
                          @RequestParam(required = false) Double a, @RequestParam(required = false) Double b,
                          @RequestParam(required = false) Double a2, @RequestParam(required = false) Double b2){
        ModelMap modelMap = new ModelMap();
        if (a != null && b != null && work_B != null && bas_B != null ){
            modelMap.addAttribute("a", a);
            modelMap.addAttribute("b", b);
            modelMap.addAttribute("a2", a2);
            modelMap.addAttribute("b2", b2);
            modelMap.addAttribute("work_B", work_B);
            modelMap.addAttribute("bas_B", bas_B);
            modelMap.addAttribute("result", (((Math.ceil(b / work_B)) * a * bas_B) + ((Math.ceil(b2 / work_B)) * a2 * bas_B)));
            modelMap.addAttribute("sam", (int)((((Math.ceil(b / work_B)) * a * bas_B) + ((Math.ceil(b2 / work_B)) * a2 * bas_B))) * 6);
            modelMap.addAttribute("kl",(int)(Math.ceil((b / work_B) + (b2 / work_B))));


        }else {
            modelMap.addAttribute("result",  "" );
        }
        return modelMap;
    }
}