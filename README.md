# forex-service
Forex service for currency conversions


This application is facilitates Currency Conversion for multiple currencies. 

For this, we use external API https://api.exchangeratesapi.io which has all the listed currencies along with their conversion rates.

We use Spring Web Client to communicate with external API and fetch results.

We currently have 2 endpoints :

1) http://localhost:8080/api/exchange-rate/{date}/{baseCurrency}/{targetCurrency}

The above endpoints takes in date, baseCurrency and targetCurrency as parameters and return currency conversion rate 
for targetCurrency w.r.t baseCurrency at the specified date.

Note : The above endpoint is implemented and working fine, but since, our external API (https://api.exchangeratesapi.io)
ony allows request from its premium or paid members, we are getting 403 Forbidden Access, since I'm using it as a trial user.

This exception gracefully in the code.

Since, a lot of API's are blocked or restricted to trial users on external API (https://api.exchangeratesapi.io), it becomes 
very difficult to analyze trend of currency conversion rates in past dates and implement any other functionalities.



2) http://localhost:8080/api/exchange-rate/getAllCurrencies

The above endpoint fetches all currency conversion rates which are listed on our external API (https://api.exchangeratesapi.io)

We see all the currency conversion rates with the base as Euro.

Screen Shot 2021-04-06 at 5.17.31 PM![image](https://user-images.githubusercontent.com/30754286/113706250-139e5280-96fc-11eb-9bd0-4705d593f978.png)

