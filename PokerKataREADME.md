# Poker Kata

##The brief 

Compare several pairs of poker hands and to indicate which, if either, has a higher rank.
The rules for comparison are as detailed here :
https://codingdojo.org/kata/PokerHands/

##Solution

I have two solutions for this exercise. One solution is a package with several classes and the second
solution is as a single class. 

###com.techreturners.poker package 

The package contains the classes to implement the poker kata. 
I have delegated the pattern determination (i.e. whether a hand is Straight, flush etc) to a series of 
helper classes that implement a PatterHelper interface.
Adding a pattern requires creating a helper class to check for the pattern and to add
the helper class in the correct order in the RulesEvaluator class.
I used TDD by first creating the test class for each pattern and then implementing the pattern helper.

###com.techreturners.poker.kata.PokerHand class

After completing the implementation as per the brief, 
I found a very similar PokerHand kata exercise on codewars and created a single PokerHand class by refactoring
my code above so that I could try it out on codewars. 
During this exercise I found that I could further improve some of the code to make it more simpler. 
On completing the kata I compared it to some of the best/reference solutions and 
found a few ideas to enhance my code. 
I have incorporated these into both the PokerHand class and also the com.techreturners.poker package.

