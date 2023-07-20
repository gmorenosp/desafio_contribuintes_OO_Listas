package entities;

public class TaxPayer {

	// Attributes
	private Double salaryIncome;
	private Double serciveIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;

	// Constructors
	public TaxPayer() {
	}

	public TaxPayer(Double salaryIncome, Double serciveIncome, Double capitalIncome, Double healthSpending,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.serciveIncome = serciveIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	// Getters and Setters
	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getSerciveIncome() {
		return serciveIncome;
	}

	public void setSerciveIncome(Double serciveIncome) {
		this.serciveIncome = serciveIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}

	// Method
	public Double salaryTax() {
		Double monthlySalary = salaryIncome / 12.0;

		if (monthlySalary < 3000.0) {
			return 0.0;
		} else if (monthlySalary < 5000.0) {
			return salaryIncome * 10 / 100;
		} else {
			return salaryIncome * 20 / 100;
		}
	}

	public Double serviceTax() {
		return serciveIncome * 15 / 100;
	}
	
	public Double capitalTax() {
		return capitalIncome * 20 / 100;
	}
	
	public Double grossTax() {
		return salaryTax() + serviceTax() + capitalTax();
	}
	
	public Double taxRebate() {
		
		Double deductiblExpense = healthSpending + educationSpending;
		Double maxDeductible = grossTax() * 30.0 / 100.0;
	
		if (deductiblExpense > maxDeductible) {
			return maxDeductible;
		} 
		else {
			return deductiblExpense;
		}
	}
	
	public Double netTax() {
		return grossTax() - taxRebate(); 
	}
	
	public String toString() {
		return "Imposto bruto total: "
				+ String.format("%.2f\n", grossTax())
				+ "Abatimento: "
				+ String.format("%.2f\n", taxRebate())
				+ "Imposto devido: "
				+ String.format("%.2f\n", netTax());
	}
}
