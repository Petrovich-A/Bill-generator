<div align="center">

<img src="https://github.com/Petrovich-A/Bill-generator/blob/bill_generate/src/main/resources/img/img.png"
alt="logo" width="600" height="auto" />
  <h1>Bill generator app</h1>

  <p>
    An awesome test task special for Clever Technology! 
  </p>


<!-- Badges -->
<p>
<a>
<img alt="Coveralls" src="https://img.shields.io/coverallsCoverage/github/Petrovich-A/Bill-generator">
</a>
<img alt="AppVeyor tests (branch)" src="https://img.shields.io/appveyor/tests/Petrovich-A/Bill-generator/bill_generate">
<a>
<img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/Petrovich-A/Bill-generator">
</a>
<a>
<img alt="Packagist Stars" src="https://img.shields.io/packagist/stars/Petrovich-A/Bill-generator">
</a>
<a>
<img alt="GitHub" src="https://img.shields.io/github/license/Petrovich-A/Bill-generator">
</a>
<a>
<img alt="GitHub commit activity" src="https://img.shields.io/github/commit-activity/m/Petrovich-A/Bill-generator">
</a>
</p>
</div>
<br />

<!-- Table of Contents -->

# :notebook_with_decorative_cover: Table of Contents

- [About the Project](#star2-about-the-project)
    * [Tech Stack](#space_invader-tech-stack)
    * [Database](#inbox_tray-database)
- [Getting Started](#toolbox-getting-started)
    * [Running Tests](#test_tube-running-tests)
    * [Run Locally](#running-run-locally)
- [Roadmap](#compass-roadmap)
- [License](#warning-license)
- [Contact](#handshake-contact)

<!-- About the Project -->

## :star2: About the Project

The developed application allows to generate an imitation of a store receipt (bill or check) with list of goods (products). The input data takes a set of parameters in the format `<itemId-quantity>` (itemId is the identifier of the product, quantity is its quantity. For example: 3-1, 2-5, 5-1. Card-1234 is also passed. Card-1234 means that a discount card with number 1234 has been found. 
As a result of the application's operation, the generated receipt is print in console or to a file.

<!-- TechStack -->

### :space_invader: Tech Stack

<details>
  <summary>Client</summary>
  <ul>
    <li><a href="https://www.jetbrains.com/idea/">IntelliJ IDEA 2022.1.2</a></li>
  </ul>
</details>

<details>
<summary>Database</summary>
  <ul>
    <li><a href="https://www.postgresql.org">PostgreSQL</a></li>
    <li><a href="https://www.mysql.com">MySQL</a></li>
  </ul>
</details>

<details>
<summary>DevOps</summary>
  <ul>
    <li><a href="https://www.docker.com/">Docker</a></li>
  </ul>
</details>

<!-- Database -->

### :inbox_tray: Database
 
The project is designed using two database: `MySQL` and `PostgreSQL`. DDL files are stored in `src/main/resources/database` [scripts :open_file_folder:](https://github.com/Petrovich-A/Bill-generator/tree/master/src/main/resources/database). Connection settings to the database are stored in `src/main/resources/properties/` [properties :unlock:](https://github.com/Petrovich-A/Bill-generator/tree/master/src/main/resources/properties)
The `database structure` looks like this:

**TABLE** `discount_cards`

|  Column name    |   Datatype  |   PRIMARY KEY   |   NOT NULL  |   UNIQUE KEY | AUTO INCREMENT |
|-----|-----|-----|-----|-----|----------------|
|  `id_discount_card`   |   int  |   :heavy_check_mark:  |   :heavy_check_mark:  |  :heavy_check_mark:  |        :heavy_check_mark:        |
|   `number`  |   int  |     |   :heavy_check_mark:  |    :heavy_check_mark: |                |
|   `discount_percent`  |   double  |     |   :heavy_check_mark:  |     |                |

**TABLE** `products`

|   Column name  |  Datatype   |  PRIMARY KEY   |   NOT NULL  |   UNIQUE KEY  |  AUTO INCREMENT   |
|-----|-----|-----|-----|-----|-----|
|   `id_product`  | int   |   :heavy_check_mark:  |  :heavy_check_mark:   |  :heavy_check_mark:   |   :heavy_check_mark:  |
|  `name`   |   varchar(45)   |     |   :heavy_check_mark:  |  :heavy_check_mark:   |     |
|   `prise`  |  double   |     |  :heavy_check_mark:   |     |     |
|  `is_on_sale`   |   tinyint  |     |     |     |     |

<!-- Getting Started -->

## :toolbox: Getting Started

<!-- Running Tests -->

### :test_tube: Running Tests

To run tests, run the following command

```bash
  yarn test test
```

<!-- Run Locally -->

### :running: Run Locally

Clone the project

```bash
  git clone https://github.com/Petrovich-A/Bill-generator
```

Install dependencies

```bash
  gradle --refresh-dependencies
```

<!-- Roadmap -->

## :compass: Roadmap

* [x] Among the goods, provide for promotional ones. If there are more than five of them in the bill, then make a 10% discount on this position. Show this information on your bill.
* [ ] Implement exception handling (for example, product with id or file does not exist, etc.).
* [x] Implement bill output to a file.
* [x] Describe the project in the README.md file (the stack is used, the run instructions).
* [x] Use the gradle project builder.
* [x] Place the source code of the project in any of the public repositories (bitbucket, github, gitlab).
* [x] Organize reading of initial data (products and discount cards, the format is the same) from files (in this case, you can pass the file name to the java command parameter set).
* [x] Cover the code with unit tests (at least 70%).
* [x] * Replace storage of source data in files with PostgreSQL; make 2 tables (product and discount_card); Operation DDL must be stored in src/main/resources in a file with .sql extension; store the database connection settings in application.properties.
* [ ] ** Implement a RESTFUL interface (Servlet, Spring) (for example, receive a bill via GET http://localhost:8080/bill?itemId=1&itemId=1).
* [ ] *** Deploy the application and PostgreSQL in Docker Expand the functionality at your discretion.

<!-- License -->

## :warning: License

Distributed under the no License. See LICENSE for more information.

<!-- Contact -->

## :handshake: Contact

* Petrovich Alexandr: [<img alt="linkedin" width="30px" src="https://img.icons8.com/color/48/null/linkedin.png" />](www.linkedin.com/in/petroviсh-alexаndr)  [<img alt="gmail" width="30px" src="https://img.icons8.com/color-glass/48/null/gmail.png" />](www.linkedin.com/in/petroviсh-alexаndr)
* Project link [Bill-generator](https://github.com/Petrovich-A/Bill-generator)</a>

<!-- Acknowledgments -->

## :gem: Acknowledgements

- [Shields.io](https://shields.io/)
- [Awesome README](https://github.com/matiassingers/awesome-readme)
- [Emoji Cheat Sheet](https://github.com/ikatyang/emoji-cheat-sheet/blob/master/README.md#travel--places)
- [Readme Template](https://github.com/othneildrew/Best-README-Template)