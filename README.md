<div align="center">

  <img src=![img.png](img.png) alt="logo" width="200" height="auto" />
  <h1>Bill generator app</h1>
![img_1.png](img_1.png)
  <p>
    An awesome test task special for Clever Technology! 
  </p>


<!-- Badges -->
<p>
<a>
<img alt="Coveralls" src="https://img.shields.io/coverallsCoverage/github/Petrovich-A/Bill-generator">
</a>
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

<br />

<!-- Table of Contents -->

# :notebook_with_decorative_cover: Table of Contents

- [About the Project](#star2-about-the-project)
    * [Screenshots](#camera-screenshots)
    * [Tech Stack](#space_invader-tech-stack)
- [Getting Started](#toolbox-getting-started)
    * [Running Tests](#test_tube-running-tests)
    * [Run Locally](#running-run-locally)
    * [Deployment](#triangular_flag_on_post-deployment)
- [Usage](#eyes-usage)
- [Roadmap](#compass-roadmap)
    * [Code of Conduct](#scroll-code-of-conduct)
- [License](#warning-license)
- [Contact](#handshake-contact)

<!-- About the Project -->

## :star2: About the Project

The developed application implements the functionality of generating a check in the store.

<!-- Screenshots -->

### :camera: Screenshots

<div align="center"> 
  <img src="https://placehold.co/600x400?text=Your+Screenshot+here" alt="screenshot" />
</div>


<!-- TechStack -->

### :space_invader: Tech Stack

<details>
  <summary>Client</summary>
  <ul>
    <li><a href="https://www.jetbrains.com/idea/">IntelliJ IDEA 2022.1.2</a></li>
  </ul>
</details>

<details>
  <summary>Server</summary>
  <ul>
    <li><a href="https://www.typescriptlang.org/">Typescript</a></li>
    <li><a href="https://expressjs.com/">Express.js</a></li>
    <li><a href="https://go.dev/">Golang</a></li>
    <li><a href="https://nestjs.com/">Nest.js</a></li>
    <li><a href="https://socket.io/">SocketIO</a></li>
    <li><a href="https://www.prisma.io/">Prisma</a></li>    
    <li><a href="https://www.apollographql.com/">Apollo</a></li>
    <li><a href="https://graphql.org/">GraphQL</a></li>
  </ul>
</details>

<details>
<summary>Database</summary>
  <ul>
    <li><a href="https://www.postgresql.org/">PostgreSQL</a></li>
  </ul>
</details>

<details>
<summary>DevOps</summary>
  <ul>
    <li><a href="https://www.docker.com/">Docker</a></li>
  </ul>
</details>

<!-- Features -->

### :dart: Features

- Feature 1
- Feature 2
- Feature 3

<!-- Getting Started -->

## :toolbox: Getting Started

<!-- Prerequisites -->

### :bangbang: Prerequisites

This project uses Yarn as package manager

```bash
 npm install --global yarn
```

<!-- Installation -->

### :gear: Installation

Install my-project with npm

```bash
  yarn install my-project
  cd my-project
```

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
  git clone https://github.com/Louis3797/awesome-readme-template.git
```

Go to the project directory

```bash
  cd my-project
```

Install dependencies

```bash
  yarn install
```

Start the server

```bash
  yarn start
```

<!-- Deployment -->

### :triangular_flag_on_post: Deployment

To deploy this project run

```bash
  yarn deploy
```

<!-- Usage -->

## :eyes: Usage

Use this space to tell a little more about your project and how it can be used. Show additional screenshots, code
samples, demos or link to other resources.

```javascript
import Component from 'my-project'

function App() {
    return <Component/>
}
```

<!-- Roadmap -->

## :compass: Roadmap

* [x] Todo 1
* [ ] Todo 2

1. [x] В данном задании важно показать понимание ООП, умение строить модели (выделять классы, интерфейсы, их связи),
   разделять функционал между ними, а также знать синтаксис самого языка. Обязательно применение паттернов
   проектирования (Factory, Builder, Decorator). Обратить внимание на устойчивость к изменениям в логике и избегать
   копипаста.
2. [x] Использовать Java 17, gradle 7.5.
3. [x] Приложение запускается java RunnerClassName <набор_параметров>, где набор параметров в формате itemId-quantity (
   itemId - идентификатор товара, quantity - его количество.
   Например: java CheckRunner 3-1 2-5 5-1 card-1234 должен сформировать и вывести в консоль чек содержащий в себе
   наименование товара с id=3 в количестве 1шт, то же самое с id=2 в количестве 5 штук, id=5 - одна штука и т. д.
   Card-1234 означает, что была предъявлена скидочная карта с номером 1234. Необходимо вывести в консоль сформированный
   чек (вариант на рисунке), содержащий в себе список товаров и их количество с ценой, а также рассчитанную сумму с
   учетом скидки по предъявленной карте (если она есть).
4. [x] Среди товаров предусмотреть акционные. Если их в чеке больше пяти, то сделать скидку 10% по этой позиции. Данную
   информацию отразить в чеке.
5. [x] Набор товаров и скидочных карт может задаваться прямо в коде, массивом или коллекцией объектов. Их количество и
   номенклатура имеет тестовый характер, поэтому наименование и количество свободные.
6. [x] Реализовать обработку исключений (например, товара с id или файла не существует и т. д.).
7. [x] Реализовать вывод чека в файл.
8. [x] Описать README.md файл (используемый стек, инструкцию по запуску, описание эндпоинтов, если есть).
9. [x] Использовать сборщик проекта gradle.
10. [x] Исходники разместить в любом из публичных репозиториев (bitbucket, github, gitlab).
11. [ ] Организовать чтение исходных данных (товары и скидочные карты, формат тот же) из файлов (в таком случае можно
    передавать имя файла в набор параметров команды java).
12. [ ] Покрыть функционал юнит-тестами (не менее 70%).
13. [ ] *Замена хранения исходных данных (п. 11) в файлах на PostgreSQL; сделать 2 таблицы (product и discount_card); DDL
    операции должны храниться в src/main/resources в файле с расширением *sql; настройки подключения к БД хранить в
    application.properties.
14. [ ] ** Реализовать RESTFUL - интерфейс (например, получать чек по GET http://localhost:8080/check?itemId=1&itemId=1).
    Реализация на выбор (Servlet, Spring). UI реализовывать не нужно.
15. [ ] *** Развернуть приложение и PostgreSQL в Docker Расширить функционал на свое усмотрение.
16. [ ] **** - Необязательно, но будет существенным плюсом. К этим пунктам лучше приступать после качественного решения
    базовых задач с применением принципов SOLID, декларативных подходов, оптимальных алгоритмов.

<!-- Code of Conduct -->

### :scroll: Code of Conduct

Please read the [Code of Conduct](https://github.com/Louis3797/awesome-readme-template/blob/master/CODE_OF_CONDUCT.md)

<!-- FAQ -->

## :grey_question: FAQ

- Question 1

      + Answer 1

- Question 2

      + Answer 2

<!-- License -->

## :warning: License

Distributed under the no License. See LICENSE.txt for more information.


<!-- Contact -->

## :handshake: Contact

Your Name - [@twitter_handle](https://twitter.com/twitter_handle) - email@email_client.com

Project
Link: [https://github.com/Louis3797/awesome-readme-template](https://github.com/Louis3797/awesome-readme-template)


<!-- Acknowledgments -->

## :gem: Acknowledgements

Use this section to mention useful resources and libraries that you have used in your projects.

- [Shields.io](https://shields.io/)
- [Awesome README](https://github.com/matiassingers/awesome-readme)
- [Emoji Cheat Sheet](https://github.com/ikatyang/emoji-cheat-sheet/blob/master/README.md#travel--places)
- [Readme Template](https://github.com/othneildrew/Best-README-Template)