package com.example.teknikaltest.controller;


import com.example.teknikaltest.model.Data;
import com.example.teknikaltest.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class AppController {
    @Autowired
    private DataService service;
    @RequestMapping("/output")
    public String viewHomepage(Model model){
        List<Data> listDatas = service.getDataByPrice();
        List<Data>listDataGanjil = service.getDataByPriceGanjil();
        model.addAttribute("lisdatas",listDatas);
        model.addAttribute("lisdataganjil",listDataGanjil);

        return "data";
    }
//
//    @RequestMapping("/list")
//    public String viewHomepage(Model model){
//        List<Data> listDatas = service.listAll();
//        model.addAttribute("lisdatas",listDatas);
//
//        return "data";
//    }

    @RequestMapping("/input")
    public String showNewDataForm(Model model) {
        Data data = new Data();
        model.addAttribute("data", data);

        return "new_data";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveData(@ModelAttribute("data") Data data) {
        service.save(data);

        return "redirect:/output";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditDataForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_data");

        Data data = service.get(id);
        mav.addObject("data", data);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteData(@PathVariable(name = "id") Long id) {
        service.delete(id);

        return "redirect:/outut";
    }
}
