# Q-ProsAutoTask
This a Simple Automation project for Creating an account to a website, login and Add to Cart. it was made with Selenium Java with Junit and TestNG

## Prerequisites & Installation
1) Before starting with the project, you need to install Java on your system.
2) Use any IDE you want, I Chose Eclipse
3) While Initialting everything, make sure you have the Correct driver. I Used Chrome Drive with old version (114.0.5735.199)


## Code and Test Scripts
Now Let's Break down the Code, This solution was deigned with POM as shown in the below image.

![POM](https://github.com/TarekAshraf96/Q-ProsAutoTask/assets/44756402/489d9fbc-822e-4d69-9a1f-e01e31742475)


we will start with the Register and Login Scripts

![SignUpandLogin](https://github.com/TarekAshraf96/Q-ProsAutoTask/assets/44756402/39e982e4-f98b-4713-94b8-ef385591bc11)

In case you Already have an Account that you may prefer to use, you can directly go to the Login test Script and provide you Credentials

![Login](https://github.com/TarekAshraf96/Q-ProsAutoTask/assets/44756402/ace8f8df-c76a-4c9c-b368-f61864ca36b3)

The categories_Test checks that every category in the website is opened and has items inside it, you first pass the name of the Categories you wish to open like below:

![CategoryTest](https://github.com/TarekAshraf96/Q-ProsAutoTask/assets/44756402/5475f76f-5083-4b47-9f90-be1e8e4a9d74)

And then when the Cateogries names are passed, this is how the Function will work:

![CategoryFunction](https://github.com/TarekAshraf96/Q-ProsAutoTask/assets/44756402/ac5ede79-5a7b-4c93-8340-54c063b5f458)


The addToCart_Test Script contains multiple Scenarios. Add item to cart, Remove item from cart and Checkout Succesfully.

We will Start with the checkAddingItemToCart Test

![CheckAddToCart](https://github.com/TarekAshraf96/Q-ProsAutoTask/assets/44756402/aff10b8c-defc-4113-ace7-58ee87532d98)


The checkRemovingItemFromCart Does Most of the Steps of the checkAddingItemToCart. but at the end of it we remove the target item then Assert it is indeed removed

![RemoveFromCart](https://github.com/TarekAshraf96/Q-ProsAutoTask/assets/44756402/adaa7992-7b1f-4c0d-a00c-7188d4cf441e)

But there is One Tricky Part for the delete. We could have multiple items with multiple delete Options, so in order to make it work correctly, we applied it as below:

![DeleteFunction](https://github.com/TarekAshraf96/Q-ProsAutoTask/assets/44756402/cc5debfe-e6c5-4de1-83fe-bc3c22eb7195)



And Finally for the checkItemCheckout test, we provide the neede data for the payment process:

![CheckoutItem](https://github.com/TarekAshraf96/Q-ProsAutoTask/assets/44756402/dbf410dc-bbcc-46d0-b8a3-915b810456dd)


And That Will be the Quick Tour of what the Code is Doing and how it works. Thank you for you time :D
