package pl.krakow.uek.pp5.creditcard.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CreditCardTest {


    private static final double LIMIT = 2000;

    @Test
    public void isAllowAssignCreditCard(){
        //Arrange / Given
        CreditCard card  = new CreditCard("1313 1312 4423 5231");
        //Act /When
        card.assignLimit(BigDecimal.valueOf(LIMIT));
        //Assert /Then
        Assert.assertTrue(card.getLimit().equals(BigDecimal.valueOf(LIMIT)));
    }

    @Test
    public void creditBelowGeneralLimitIsNotPossible(){
        //Arrange
        CreditCard card  = new CreditCard("1313 1312 4423 5231");
        //Act

        //Assert
        try {
            card.assignLimit(BigDecimal.valueOf(50));
            Assert.fail("exption should be thrown");
            }
        catch (CreditCardBelowLimitException e) {
            Assert.assertTrue(true);
            }
    }
}
