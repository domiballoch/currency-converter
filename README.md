[![Actions Status](https://github.com/domiballoch/currency-converter/actions/workflows/maven.yml/badge.svg)](https://github.com/domiballoch/currency-converter/actions)
[![codecov](https://codecov.io/gh/domiballoch/currency-converter/branch/master/graph/badge.svg?token=3DQWELQG2V)](https://codecov.io/gh/domiballoch/currency-converter)
[![GitHub version](https://badge.fury.io/gh/domiballoch%2Fcurrency-converter.svg)](https://badge.fury.io/gh/domiballoch%2Fcurrency-converter)
[![forthebadge](https://forthebadge.com/images/badges/built-by-neckbeards.svg)](https://forthebadge.com)

<h1>Currency Converter Example</h1>
<h4>Author: Dominic Balloch</h4>

<h3>Description</h3>
A currency converter example using five currencies with tests.
<BR/>Rest controller added but DB is not needed.

<h3>Design</h3>
Strategy pattern using a converter interface and a switch statement.
<br/>Currency as Enum and exchange rate as BigDecimal in config properties.

<h3>Learning Outcomes</h3>
Advanced strategy pattern.

<h3>Prerequisites</h3>
Java 11
<br/> Spring Boot 2.4.5
<br/>Maven 3.6.3
<br/>No SQL required

<h3>Build project</h3>
mvn clean install
<br/>spring-boot:run

<h3>Endpoint</h3>
localhost:8080/converter/convert/{amount}/{currencyType}
<br/>For amount put any figure.
<br/>For currency type it has to be an enum, in capitals such as:
<br/>POUND, USD, EURO, YEN, YUAN

<h3>Logging level</h3>
DEBUG - set filepath as/if required