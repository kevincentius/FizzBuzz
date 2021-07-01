package kevin.fizzbuzz;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class FizzbuzzController {
	
	@GetMapping("fizzbuzz")
	public String[] fizzbuzz( 
			@RequestParam(name = "num")
			@NotNull
			@Min(0)
			Integer num
	) {
		String[] result = new String[num];
		for (int i = 1; i <= num; i++) {
			result[i-1] = handleNum(i);
		}
		return result;
	}
	
	private String handleNum(int i)
	{
		if (i % 15 == 0)
			return "FizzBuzz";
		else if (i % 3 == 0)
			return "Fizz";
		else if (i % 5 == 0)
			return "Buzz";
		else
			return String.valueOf(i);
	}
}
