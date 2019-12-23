package com.softtek.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.softtek.academia.entity.City;
import com.softtek.academia.entity.State;
import com.softtek.academia.service.CityService;
import com.softtek.academia.service.StateService;


@Controller
public class CityController {
	// Constructor based Dependency Injection
		private CityService cityService;

		public CityController() {

		}
		
		
		@Autowired
		public CityController(CityService cityService) {
			this.cityService = cityService;
		}


		//@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
		//public ModelAndView hello(HttpServletResponse response) throws IOException {
			//ModelAndView mv = new ModelAndView();
			//mv.setViewName("home");
		//return mv;
		//}

		// Get All Users
		@RequestMapping(value = "/allCitys", method = RequestMethod.POST)
		public ModelAndView displayAllCity() {
			System.out.println("User Page Requested : All Citys");
			ModelAndView mv = new ModelAndView();
			List<City> cityList = cityService.getAllCitys();
			mv.addObject("cityList", cityList);
			mv.setViewName("allCitys");

			return mv;
		}
		

		@RequestMapping(value = "/addCity", method = RequestMethod.GET)
		public ModelAndView displayNewUserForm() {
			ModelAndView mv = new ModelAndView("addCity");
			mv.addObject("headerMessage", "Add City Details");
			mv.addObject("city", new City());
			return mv;
		}

		@RequestMapping(value = "/addCity", method = RequestMethod.POST)
		public ModelAndView saveNewCity(@ModelAttribute City city, BindingResult result) {
			ModelAndView mv = new ModelAndView("redirect:/home");

			if (result.hasErrors()) {
				return new ModelAndView("error");
			}
			boolean isAdded = cityService.saveCity(city);
			if (isAdded) {
				mv.addObject("message", "New city successfully added");
			} else {
				return new ModelAndView("error");
			}

			return mv;
		}

		@RequestMapping(value = "/editCity/{id}", method = RequestMethod.GET)
		public ModelAndView displayEditUserForm(@PathVariable Long id) {
			ModelAndView mv = new ModelAndView("/editCity");
			City city = cityService.getCitysById(id);
			mv.addObject("headerMessage", "Edit city Details");
			mv.addObject("city", city);
			return mv;
		}

		@RequestMapping(value = "/editCity/{id}", method = RequestMethod.POST)
		public ModelAndView saveEditedCity(@ModelAttribute City city, BindingResult result) {
			ModelAndView mv = new ModelAndView("redirect:/home");

			if (result.hasErrors()) {
				System.out.println(result.toString());
				return new ModelAndView("error");
			}
			boolean isSaved = cityService.saveCity(city);
			if (!isSaved) {

				return new ModelAndView("error");
			}

			return mv;
		}

		@RequestMapping(value = "/deleteCity/{id}", method = RequestMethod.GET)
		public ModelAndView deleteCityById(@PathVariable Long id) {
			boolean isDeleted = cityService.deleteCityById(id);
			System.out.println("User deletion respone: " + isDeleted);
			ModelAndView mv = new ModelAndView("redirect:/home");
			return mv;

		}

}
