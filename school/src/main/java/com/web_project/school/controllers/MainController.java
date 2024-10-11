package com.web_project.school.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("name","sula");
        return "homePage";
    }

    @GetMapping("/main")
    public String main(Model model) {
        return "Main";
    }


    @PostMapping("calculate")
    public String calculate(@RequestParam("operand1") double operand1,
        @RequestParam("operand2") double operand2,
        @RequestParam("operator") String operator,
                            Model model){
        double result = switch (operator){
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "/" -> operand1 / operand2;
            case "*" -> operand1 * operand2;
            default -> 0.0;
        };
        model.addAttribute("result", result);
        return "result";
    }
    @GetMapping("/calculator")
    public String calculator(Model model){
        return "calculator";
    }

    @GetMapping("/convert")
    public String convert(@RequestParam("valyta1") double valyta1,
                          @RequestParam("valyta2") String valyta2,
                          @RequestParam("valyta") String valyta,
                          Model model) {
        double result = 0.0;
        boolean conversionFound = true;

        if (valyta.equals("Рубль") && valyta2.equals("Дирхам")) {
            result = valyta1 * 0.039666;
        } else if (valyta.equals("Рубль") && valyta2.equals("Доллар")) {
            result = valyta1 * 0.01080;
        }else if (valyta.equals("Доллар") && valyta2.equals("Дирхам")) {
            result = valyta1 * 3.67;
        } else if (valyta.equals("Доллар") && valyta2.equals("Рубль")) {
            result = valyta1 * 92.58;
        } else if (valyta.equals("Доллар") && valyta2.equals("Сом")) {
            result = valyta1 * 84.25;
        } else if (valyta.equals("Рубль") && valyta2.equals("Сом")) {
            result = valyta1 * 0.909852;
        } else if (valyta.equals("Дирхам") && valyta2.equals("Сом")) {
            result = valyta1 * 22.94;
        } else if (valyta.equals("Дирхам") && valyta2.equals("Рубль")) {
            result = valyta1 * 25.214;
        }else if (valyta.equals("Дирхам") && valyta2.equals("Доллар")) {
            result = valyta1 * 0.272254;
        } else if (valyta.equals("Сом") && valyta2.equals("Дирхам")) {
            result = valyta1 * 0.0435964;
        } else if (valyta.equals("Сом") && valyta2.equals("Рубль")) {
            result = valyta1 * 1.14;
        }else if (valyta.equals("Сом") && valyta2.equals("Доллар")) {
            result = valyta1 * 0.01186;
        }
        if (conversionFound) {
            model.addAttribute("result", result);
        }
        return "result";
    }

    @GetMapping("/converter")
    public String converter(Model model) {
        return "converter";
    }
}
