package com.naukma.steps;

import com.naukma.GreatestCommonDivisorFinder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class GreatestCommonDivisorSteps {

    private int numberA;
    private int numberB;
    private int gcd;
    private GreatestCommonDivisorFinder gcdFinder = new GreatestCommonDivisorFinder();

    @Given("I have numbers {int} and {int}")
    public void i_have_numbers(int a, int b) {
        this.numberA = a;
        this.numberB = b;
    }

    @When("I find the greatest common divisor")
    public void i_find_the_greatest_common_divisor() {
        gcd = gcdFinder.findGCD(numberA, numberB);
    }

    @Then("the greatest common divisor should be {int}")
    public void the_greatest_common_divisor_should_be(int expectedGCD) {
        assertThat(gcd).isEqualTo(expectedGCD);
    }
}