package kevin.fizzbuzz;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { FizzbuzzApplication.class })
public class FizzbuzzServiceTests {

	@Autowired
	private FizzbuzzController fizzbuzzController;
	
	@Test
	void zeroReturnsEmpty() {
		String[] res = fizzbuzzController.fizzbuzz(0);
		assertEquals(0, res.length);
	}

	@Test
	void oneReturnsOne() {
		String[] res = fizzbuzzController.fizzbuzz(1);
		String[] expected = { "1" };
		assertArrayEquals(expected, res);
	}

	@Test
	void threeIsFizz_fiveIsBuzz() {
		String[] res = fizzbuzzController.fizzbuzz(30);
		String[] expected = { 
				"1", 	"2", 	"fizz", "4", 	"buzz", 	"fizz", "7", 	"8", 	"fizz", "buzz",
				"11", 	"fizz", "13", 	"14", 	"fizzbuzz", "16", 	"17", 	"fizz", "19", 	"buzz",
				"fizz", "22", 	"23", 	"fizz", "buzz", 	"26", 	"fizz", "28", 	"29", 	"fizzbuzz",
		};
		assertArrayEquals(expected, res);
	}
}
