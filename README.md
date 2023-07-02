# TFT_Statistics
> **롤체전적검색/통계 사이트** <br/> **개발기간: 2021.03 ~ 2021.09** <br/> 
<br/>

## 프로젝트 소개 

[라이엇 디벨로퍼](https://developer.riotgames.com/)에서 제공하는 API를 가지고 롤토체스의 전적들을 검색하고 이를 분류하여 통계치를 보여주는 웹 프로젝트입니다. 대표적으로 유저 닉네임을 입력하여 전적을 검색하는 기능과 패치 전후로 메타의 변화가 어떻게 이루어지는지 수치로 제공합니다. 저희들은 이번 프로젝트를 통해 기존 통계 사이트에서 보여주는 통계들보다 폭넓고 상세한 내용을 


**[프론트엔드 프로젝트](https://github.com/nulzi/MaroMaro)** 

<br/>

## 웹개발팀 소개 

|육마로|정의현|김성준|김태영|
|:---:|:---:|:---:|:---:|
|<img width="130px" src="https://avatars.githubusercontent.com/u/55569476?v=4"/>|<img width="130px" src="https://avatars.githubusercontent.com/u/98465697?v=4"/>|<img width="130px" src="https://avatars.githubusercontent.com/u/90247223?v=4"/>|<img width="130px" src="https://avatars.githubusercontent.com/u/74344132?v=4"/>|
|[@RDDCat](https://github.com/RDDcat)|[@Euihyunee](https://github.com/Euihyunee)|[@kim-song-jun](https://github.com/kim-song-jun)|[@nulzi](https://github.com/nulzi)|
|한국공학대학교 소프트웨어학과 4학년|한국공학대학교 소프트웨어학과 4학년|한국공학대학교 소프트웨어학과 4학년|한국공학대학교 소프트웨어학과 4학년|
<br/>


## ⚙️ 기술 스택

**백엔드**  
![Spring Boot](https://camo.githubusercontent.com/bc562412c99f666d8c2f62485201afe06dec01a60e4a2879a350197dcfb7acc5/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e672d3644423333463f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e67266c6f676f436f6c6f723d7768697465) ![JAVA](https://camo.githubusercontent.com/a0f9c9f1295e65f8c081e5e6073840e309726163c310542f8c0acb5aa60ba5ad/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a4156412d3030373339363f7374796c653d666f722d7468652d6261646765266c6f676f3d6a617661266c6f676f436f6c6f723d7768697465) ![MariaDB](https://camo.githubusercontent.com/876c5ee70891ede4dbc02eda4cfb28ad64f5c12bcb86c1110bbb7026e66c5a4e/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6d6172696144422d3030333534353f7374796c653d666f722d7468652d6261646765266c6f676f3d6d617269614442266c6f676f436f6c6f723d7768697465)

**프론트엔드**  
![Vue Js](https://camo.githubusercontent.com/93d5f331c22892dda02fa83b38023151c176f47cc2afc7033b55012172b2aeb1/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f5675652e6a732d3446433038443f6c6f676f3d767565646f746a73266c6f676f436f6c6f723d666666267374796c653d666c6174) ![JavaScript](https://camo.githubusercontent.com/735bae248e07b7c9283e5e4e482c9992e3b4651312bdfbde23d0b13515220f1c/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a6176615363726970742d4637444631453f6c6f676f3d6a617661736372697074266c6f676f436f6c6f723d303030267374796c653d666c6174) ![Bootstrap Badge](https://img.shields.io/badge/Bootstrap-7952B3?logo=bootstrap&logoColor=fff&style=flat-square)

---
<br/>

## 📱 기능 설명 

1. 전적 검색
    - 유저 닉네임으로 전적을 검색함
    - 검색 요청이 들어올 시 라이엇API를 요청하여 DB에 없는 데이터는 저장하고,  
    DTO로 정제하여 전적 검색 요청에 응답함 

<br/>

2. 통계 데이터 분석 
    - 통계 데이터는 크게 챔피언들로 이루어진 덱 통계와, 어떤 아이템들이 승률이 높은지 파악할 수 있는 아이템 통계, 그리고 챔피언들의 승률 통계 리스트가 있습니다. 
    - 저티어의 전적 데이터들은 통계가 의미없을 것이라 판단하여 일정 티어 이상부터 통계에 반영했습니다.
    - 덱 통계 구성 : [덱 이름][티어][챔피언 리스트][버전][빈도][평균등수]
    - 아이템 통계 구성 : [아이템 명][티어][버전][빈도][평균등수]
    - 챔피언 통계 구성 : [챔피언 명][티어][버전][빈도][평균등수]

<br/>

## 🔐 코드 설명 

**유저의 요청을 담은 History와 통계 요청인 Stat으로 구분하여 Controller 작성**
<br/>

1. package com.grassparty.tft.History.Controller

- 유저 닉네임을 Get방식으로 받아와 유저 전적을 전해줌
```java
    @GetMapping("/user/{userName}")
    public UserInfoDTO GetUserInfo(@PathVariable String userName){
        return historyService.GetUserInfo(userName);
    }
```

2. package com.grassparty.tft.Stat.Controller

- 덱 티어리스트 제공 
```java
@GetMapping("/deck")
    public List<StatDeckDTO> GetChamp(){
        return mocker.GetMockDeck();
    }
```  
- 챔피언 티어리스트 제공
 ```java
@GetMapping("/unit")
    public List<StatChampionResultDAO> GetStatChampionResult(){
        return statService.GetStatChampionResult();
    }
```
- 아이템 티어리스트 제공 
```java
@GetMapping("/item")
    public StatItemDTOs GetItem(){
        return mocker.GetMockItem();
    }
```