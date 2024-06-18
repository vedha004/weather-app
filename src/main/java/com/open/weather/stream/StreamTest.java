package com.open.weather.stream;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class StreamTest {

	public static void main(String[] args) {
		 Order order1 = Order.builder()
	                .orderId(1)
	                .orderDate(LocalDate.of(2024, 5, 15))
	                .items(List.of(
	                        Item.builder().itemName("Laptop").itemPrice(new BigDecimal("1200.00")).build(),
	                        Item.builder().itemName("Mouse").itemPrice(new BigDecimal("25.00")).build()
	                ))
	                .build();

	        Order order2 = new Order(2, LocalDate.of(2024, 4, 10), Arrays.asList(
	                new Item("Keyboard", new BigDecimal("80.00")),
	                new Item("Monitor", new BigDecimal("300.00"))
	        ));

	        Order order3 = new Order(3, LocalDate.of(2024, 5, 25), Arrays.asList(
	                new Item("Headphones", new BigDecimal("150.00"))
	        ));
		List<Order> orders = Arrays.asList(order1, order2, order3);



		/*
        

		Map<Object, List<Order>> groupByMonth = orders.stream().collect(Collectors.groupingBy(order -> order.getOrderDate().getMonth()));
		System.out.println(groupByMonth);
		BigDecimal totalPrice = orders.stream()
				.flatMap(o -> o.getItems().stream()).map(Item::getItemPrice)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
        // Print sample orders
        System.out.println(totalPrice);
		LocalDate oneYearAgo = LocalDate.now().minusYears(1);
		orders.stream().filter(order -> order.getOrderDate().isAfter(oneYearAgo));





		List<Transaction> transactions1 = Arrays.asList(
				Transaction.builder().transactionId("1").transactionType("Food").amount(new BigDecimal("10.50")).build(),
				Transaction.builder().transactionId("2").transactionType("Electronics").amount(new BigDecimal("99.99")).build(),
				Transaction.builder().transactionId("3").transactionType("Food").amount(new BigDecimal("15.75")).build()
		);

		List<Transaction> transactions2 = Arrays.asList(
				Transaction.builder().transactionId("2").transactionType("Electronics").amount(new BigDecimal("99.99")).build(),
				Transaction.builder().transactionId("4").transactionType("Clothing").amount(new BigDecimal("25.00")).build(),
				Transaction.builder().transactionId("5").transactionType("Food").amount(new BigDecimal("10.50")).build()
		);


		Map<String, BigDecimal> result = Stream.concat(transactions1.stream(), transactions2.stream())
				.distinct().collect(Collectors.groupingBy(Transaction::getTransactionType,
						Collectors.reducing(BigDecimal.ZERO, Transaction::getAmount, BigDecimal::add)));

		result.forEach((type,amount) ->   System.out.println(type+ " " + amount));


		List<Integer> integers = generateLargeList(10_000_000);

		// Measure time for sequential stream
		long startSequential = System.currentTimeMillis();
		long sumOfSquaresSequential = integers.stream()
				.mapToInt(Integer::intValue)
				.map(i -> i * i)
				.sum();
		long endSequential = System.currentTimeMillis();
		long durationSequential = endSequential - startSequential;

		// Measure time for parallel stream
		long startParallel = System.currentTimeMillis();
		long sumOfSquaresParallel = integers.parallelStream()
				.mapToInt(Integer::intValue)
				.map(i -> i * i)
				.sum();
		long endParallel = System.currentTimeMillis();
		long durationParallel = endParallel - startParallel;

		// Print the results
		System.out.println("Sum of squares (Sequential): " + sumOfSquaresSequential);
		System.out.println("Time taken (Sequential): " + durationSequential + " ms");

		System.out.println("Sum of squares (Parallel): " + sumOfSquaresParallel);
		System.out.println("Time taken (Parallel): " + durationParallel + " ms");



		Item item1 = Item.builder()
				.itemName("Laptop")
				.itemPrice(new BigDecimal("1200.00"))
				.build();

		Item item2 = Item.builder()
				.itemName("Mouse")
				.itemPrice(new BigDecimal("25.00"))
				.build();

		Item item3 = Item.builder()
				.itemName("Keyboard")
				.itemPrice(new BigDecimal("80.00"))
				.build();

		Item item4 = Item.builder()
				.itemName("Monitor")
				.itemPrice(new BigDecimal("300.00"))
				.build();

		// Create sample data for employees
		Employee employee1 = Employee.builder()
				.orderId(1)
				.orderDate(LocalDate.of(2024, Month.MAY, 15))
				.items(Arrays.asList(item1, item2))
				.build();

		Employee employee2 = Employee.builder()
				.orderId(2)
				.orderDate(LocalDate.of(2024, Month.APRIL, 10))
				.items(Arrays.asList(item3, item4))
				.build();

		Employee employee3 = Employee.builder()
				.orderId(3)
				.orderDate(LocalDate.of(2024, Month.MAY, 25))
				.items(Arrays.asList(item1, item3, item4))
				.build();

		List<Employee> employees = Arrays.asList(employee1, employee2, employee3);

        for (Employee e : employees) {
            if (e.getItems().stream()
                    .anyMatch(i -> i.getItemName().startsWith("L"))) {
                System.out.println(e);
            }
        }

    }

	private static List<Integer> generateLargeList(int size) {
		List<Integer> list = new ArrayList<>(size);
		for (int i = 1; i <= size; i++) {
			list.add(i);
		}
		return list;
		*/
	}



}
