import functions.*
import org.junit.Assert
import org.junit.Test

class Tests{
    @Test
    fun listRecivedLastItemReturned(){
        val list = listOf(1,2,4,5)
        Assert.assertEquals(list.last(), last(list))
    }

    @Test
    fun listEmpityRecivedNullReturned() {
        val list = listOf<Int>()
        Assert.assertEquals(null, last(list))
    }

    @Test
    fun penultimateElementOnAListWithOneElement(){
        val list = listOf(1)
        Assert.assertEquals(null, penultimate(list))
    }
    @Test
    fun penultimateElementOnAListOfNMembers(){
        val list = listOf(1,2,3,4)
        val penultimate = last(list.take(list.size - 1))

        Assert.assertEquals(penultimate,penultimate(list))
    }

    @Test
    fun nthElementOnAListOfSizeMoreThanZero(){
        val list = listOf(1,2,3,4)
        Assert.assertEquals(4, nth(3,list))
    }

    @Test
    fun nthElementOnAEmptyList(){
        val list = listOf<Int>()
        Assert.assertEquals(null,nth(5,list))
    }

    @Test
    fun nthElementOfListWithARequestGreaterThanTheSize(){
        val list = listOf(1,2)
        Assert.assertEquals(null,nth(3, list))
    }

    @Test
    fun lengthOfAEmptyList(){
        val list = listOf<Int>()
        Assert.assertEquals(0, length(list))
    }

    @Test
    fun lengthOfAListOfFiveElements(){
        val list = listOf(1,2,3,4,5)
        Assert.assertEquals(list.size, length(list))
    }

    @Test
    fun reverseOfAListWithFiveElements(){
        val list = listOf(1,2,3,4,5)
        val listR = list.reversed()
        Assert.assertEquals(listR, reverse(list))
    }

    @Test
    fun reverseOfAEmptyList(){
        val list = listOf<Char>()
        Assert.assertEquals(list, reverse(list))
    }

    @Test
    fun isPalindromeOfAListWithOneElement(){
        val list = listOf(1)
        Assert.assertEquals(true, isPalindrome(list))
    }

    @Test
    fun isPalindromeOfAListWithFiveElementsWhichIsPalindrome(){
        val list = listOf(1,3,5,3,1)
        Assert.assertEquals(true, isPalindrome(list))
    }

    @Test
    fun isPalindromeOfAListWithSixElementsWhichIsNotPalindrome(){
        val list = listOf(1,2,4,5,6,7)
        Assert.assertEquals(false,isPalindrome(list))
    }

    @Test
    fun flattenOfAListOfListOfFiveElements(){
        val list = listOf(1, listOf(2), listOf(1,2,3))
        val listF = listOf(1,2,1,2,3)
        Assert.assertEquals(listF, flatten(list))
    }
    @Test
    fun flattenOfAListFlattend(){
        val list = listOf(1,2,3,4)
        Assert.assertEquals(list, flatten(list))
    }

    @Test
    fun flattenOfAEmptyList(){
        val list = listOf<Nothing>()
        Assert.assertEquals(list, flatten(list))
    }

    @Test
    fun flattenOfAListOfListOfList(){
        val list = listOf(1,listOf(1,listOf(1,2)),1)
        val listE = listOf(1,1,1,2,1)

        Assert.assertEquals(listE, flatten(list))
    }

    @Test
    fun compressEmptyList(){
        val list = emptyList<Nothing>()
        Assert.assertEquals(list, compress(list))
    }

    @Test
    fun compressListWith20Elements(){
        var list = listOf(1,1,1,1,1,1,2,2,2,2,2,3,3,3,3,3,3,3,3,3)
        var expected = listOf(1,2,3)
        Assert.assertEquals(expected,compress(list))
    }
}