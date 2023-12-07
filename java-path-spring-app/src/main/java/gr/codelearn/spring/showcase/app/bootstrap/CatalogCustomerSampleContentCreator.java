package gr.codelearn.spring.showcase.app.bootstrap;

import gr.codelearn.spring.showcase.app.base.BaseComponent;
import gr.codelearn.spring.showcase.app.model.Category;
import gr.codelearn.spring.showcase.app.model.Customer;
import gr.codelearn.spring.showcase.app.model.CustomerCategory;
import gr.codelearn.spring.showcase.app.model.Product;
import gr.codelearn.spring.showcase.app.service.CategoryService;
import gr.codelearn.spring.showcase.app.service.CustomerService;
import gr.codelearn.spring.showcase.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

@Component
@Profile("generate-catalog-customers")
@RequiredArgsConstructor
public class CatalogCustomerSampleContentCreator extends BaseComponent implements CommandLineRunner {
	private final ProductService productService;
	private final CategoryService categoryService;
	private final CustomerService customerService;

	@Override
	public void run(String... args) throws Exception {
		Category newCategory = categoryService.create(Category.builder().description("Mobile Phones").build());
		logger.info("Created {}.", newCategory);

		List<Product> products = List.of(
				Product.builder().serial("SN1000-0001").name("Apple iPhone 12 Pro 5G 512GB")
					   .price(BigDecimal.valueOf(1629)).category(newCategory).build(),
				Product.builder().serial("SN1000-0002").name("Apple iPhone 12 Pro Max 5G 512GB")
					   .price(BigDecimal.valueOf(1749)).category(newCategory).build(),
				Product.builder().serial("SN1100-0001").name("Samsung Galaxy S21 Ultra")
					   .price(BigDecimal.valueOf(1479.99)).category(newCategory).build(),
				Product.builder().serial("SN1100-0002").name("Samsung Galaxy S20 Ultra")
					   .price(BigDecimal.valueOf(1199)).category(newCategory).build(),
				Product.builder().serial("SN1200-0001").name("Huawei P40 Pro")
					   .price(BigDecimal.valueOf(899.49)).category(newCategory).build(),
				Product.builder().serial("SN1300-0001").name("Xiaomi Redmi 9A")
					   .price(BigDecimal.valueOf(199.75)).category(newCategory).build(),
				Product.builder().serial("SN1400-0001").name("RealMe C11")
					   .price(BigDecimal.valueOf(129)).category(newCategory).build(),
				Product.builder().serial("SN1500-0001").name("Honor 10 Lite")
					   .price(BigDecimal.valueOf(179)).category(newCategory).build(),
				Product.builder().serial("SN1000-0003").name("Apple iPhone 12 Pro Max 5G 128GB")
					   .price(BigDecimal.valueOf(1339)).category(newCategory).build(),
				Product.builder().serial("SN1000-0004").name("Apple iPhone 11 Pro 256GB")
					   .price(BigDecimal.valueOf(1299.99)).category(newCategory).build());

		var productsCreated = productService.createAll(products);
		logger.info("Created {} products.", productsCreated.size());
		productsCreated.stream()
					   .sorted(Comparator.comparing(Product::getId))
					   .forEach(p -> logger.debug("{}. {}", p.getId(), p));

		List<Customer> customersCreated = customerService.createAll(
				Customer.builder().email("c.giannacoulis@codehub.gr")
						.firstname("Constantinos").lastname("Giannacoulis")
						.address("3583 Tennessee Avenue")
						.customerCategory(CustomerCategory.INDIVIDUAL).age(47).build(),
				Customer.builder().email("john.porter@gmailx.com")
						.firstname("John").lastname("Porter")
						.address("2955 Blackwell Street")
						.customerCategory(CustomerCategory.BUSINESS).age(40).build(),
				Customer.builder().email("malcolm.paker@gmailx.com")
						.firstname("Malcolm").lastname("Parker")
						.address("4071 Kelly Drive")
						.customerCategory(CustomerCategory.GOVERNMENT).age(32).build(),
				Customer.builder().email("terry.jones@gmailx.com")
						.firstname("Terry").lastname("Jones")
						.address("3849 Hinkle Lake Road")
						.customerCategory(CustomerCategory.BUSINESS).age(57).build(),
				Customer.builder().email("peter.mercury@outlookx.com")
						.firstname("Peter").lastname("Mercury")
						.address("Freddie Street 28th")
						.customerCategory(CustomerCategory.INDIVIDUAL).age(32).build(),
				Customer.builder().email("magdalene.ferguson@gmailx.com")
						.firstname("Magdalene").lastname("Ferguson")
						.address("Jelly Avenue 73")
						.customerCategory(CustomerCategory.INDIVIDUAL).age(32).build(),
				Customer.builder().email("jones.pirves@gmailx.com")
						.firstname("Jones").lastname("Pirves")
						.address("3rd Mountain Hike, 3")
						.customerCategory(CustomerCategory.INDIVIDUAL).age(32).build(),
				Customer.builder().email("michael.anderson@gmailx.com")
						.firstname("Michael").lastname("Anderson")
						.address("Hollywood Street 63")
						.customerCategory(CustomerCategory.BUSINESS).age(32).build(),
				Customer.builder().email("yennefer.lawrance@windowslivex.com")
						.firstname("Yennefer").lastname("Lawrance")
						.address("Rivia 43")
						.customerCategory(CustomerCategory.BUSINESS).age(32).build(),
				Customer.builder().email("mary.ferry@windowslivex.com")
						.firstname("Mary").lastname("Ferry")
						.address("Downtown 17, California")
						.customerCategory(CustomerCategory.GOVERNMENT).age(32).build());

		logger.info("Created {} customers.", customersCreated.size());
		customersCreated.stream()
						.sorted(Comparator.comparing(Customer::getId))
						.forEach(c -> logger.debug("{}. {}", c.getId(), c));
	}
}
