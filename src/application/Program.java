package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<>();

		// PART 1 - READING DATA:
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.printf("Digite os dados do %do contribuinte:\n", (i + 1));
			System.out.print("Renda anual com salário: ");
			Double salary = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			Double service = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			Double capital = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			Double health = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			Double education = sc.nextDouble();

			TaxPayer payer = new TaxPayer(salary, service, capital, health, education);

			list.add(payer);
		}

		// PART 2 - LISTING TAXPAYER:
		
		for (TaxPayer payer : list) {
			System.out.println();
			System.out.println("Digite os dados do "+ (list.indexOf(payer)+1) + "o contribuinte:");
			System.out.println(payer.toString());
		}

		sc.close();

	}
}
