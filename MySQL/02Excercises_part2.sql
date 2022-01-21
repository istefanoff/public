
# Display all mountain peaks in alphabetical order

SELECT * FROM peaks
ORDER BY peak_name;

# Find the 30 biggest countries by population from Europe.
# Display the country name and population. Sort the results by population (from biggest to smallest),
# then by country alphabetically. 

SELECT country_name, population FROM countries
ORDER BY POPULATION DESC,country_name
LIMIT 30;

/* Find all countries along with information about their currency.
Display the country name, country code and information about its currency: either "Euro" or "Not Euro".
Sort the results by country name alphabetically. */

SELECT country_name,country_code,IF(currency_code ='EUR','Euro','Not Euro') AS currency FROM countries
ORDER BY country_name;

SELECT `name` FROM `characters`
ORDER BY `name`;



