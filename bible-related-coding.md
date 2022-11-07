# Bible Reading Coding

## From previous homework result, You can see it doesn't take too many years to achieve the commandment of Jesus. Why more than 2000 years has past, only less than one third of the population are Christian (2.3 billion in total)? Can you introduce a new condition or variable to simulate the real world model based on the assumptions in question 3? Explain what assumptions you introduced.

### Condition Introduced
`That a disciple can either convert a random number betwwen 0 and 2 of disciples in every 3 years. `

<img width="1280" alt="Screen Shot 2022-11-07 at 23 05 09" src="https://user-images.githubusercontent.com/26523968/200425331-92950449-8151-469f-9570-0e19f546dd0f.png">

## Suppose everyone would live up to 72 years (which is the average age of human). Among them, half are male and the other half are female, everyone will marry and a couple will have one baby at the age of 30. It has to be until 18-years old to start the training of disciple, and a disciple can keep on training disciples before he dies. The other conditions are the same in the Bible Related Coding Assignment 1. How many years will it take 13 disciples to make every human in the world to be disciples of Jesus?

### Assumptions
* Current human population: 7.7 billion
* One disciple can only train: 2 disciples at a time
* Duration for training 2 disciples: 3 years
* There is no growth of depreciation in population hence there is no birth nor death
* Each disciple can make a couple disciples in 3 years
* The growth rate of discipleship is 2x per 3 years

```
int population = 7700000000;
int numberOfDisciples = 13;
int i = 0;
while(numberOfDisciples < population){
  numberOfDisciples += numberOfDisciples * 2;
  i += 3;
}
System.out.println("It will take "+i+" years to make every human a disciple of Jesus");
```
