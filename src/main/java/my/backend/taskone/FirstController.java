package my.backend.taskone;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping("/dayOfWeek")
    public String hello(@RequestParam(value = "name") String name) {
        switch (name.toLowerCase()) {
            case "monday":
                return printDay("Понедельник");
            case "tuesday":
                return printDay("Вторник");
            case "wednesday":
                return printDay("Среда");
            case "thursday":
                return printDay("Четверг");
            case "friday":
                return printDay("Пятница");
            case "saturday":
                return printDay("Суббота");
            case "sunday":
                return printDay("Воскресенье");
            default:
                return "Укажите корректный день недели";
        }
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        return "Не указан обязательный параметр " + name;
    }

    private String printDay(String day) {
        return String.format("Сегодня %s!", day);
    }

}