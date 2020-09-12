# WHOWANT
## 목차
1. [프로젝트 개요](#1-프로젝트-개요)     
2. [개발 기간](#2-개발-기간)     
3. [구현 기술](#3-구현-기술)     
4. [프로젝트 주요 기능 및 사용자 기능](#4-프로젝트-주요-기능-및-사용자-기능)     
5. [데이터베이스](#5-데이터베이스)     
6. [문제점 및 개선사항](#6-문제점-및-개선사항)     
7. [배운 점](#7-배운-점)     
    
## 1. 프로젝트 개요
사용자가 관심있는 ```프로젝트를 후원```할 수 있고,       
직접 후원받을 ```프로젝트를 올리기```도 하는 ```크라우드 펀딩 플랫폼```
     
## 2. 개발 기간
2020.04 ~ 2020.07 (4개월)
      
## 3. 구현 기술
- FE : ```HTML5``` ```CSS3``` ```JavaScript``` ```Bootstrap 3.3.2```
- BE : ```Java``` ```JSP``` ```Spring``` ```MyBatis```
- DB : ```Oracle```
    
## 4. 프로젝트 주요 기능 및 사용자 기능
### 4-1. 프로젝트 주요 기능
#### 1. 프로젝트 올리기
![메인화면](https://user-images.githubusercontent.com/37262132/92991605-10edcd00-f520-11ea-9cdd-79e2736bd221.png)
    
        - 기본적으로 모든 회원은 프로젝트 올리기 가능
       
![프로젝트올리기1](https://user-images.githubusercontent.com/37262132/92991696-ab4e1080-f520-11ea-9d35-f3320166ac90.JPG)
![프로젝트올리기2](https://user-images.githubusercontent.com/37262132/92991704-b2751e80-f520-11ea-9462-2184a2b40f6e.JPG)
    
        - 프로젝트 개요 단계에서 제목 / 이미지 / 카테고리 / 목표 금액 / 마감일 / 소개 작성
       
![프로젝트올리기3](https://user-images.githubusercontent.com/37262132/92991730-cf115680-f520-11ea-9fe3-56a85ea8d4ee.JPG)
![프로젝트올리기4](https://user-images.githubusercontent.com/37262132/92991735-d8022800-f520-11ea-811c-d437bc734bbb.JPG)
    
        - 후원 상품이 있을 경우 프로젝트 상품 구성 단계에서 상품 등록       

※ 후원 프로젝트는 펀딩 마감일까지 목표 금액이 100% 모이지 않으면 결제가 진행되지 않는다.        
  이는 도중에 프로젝트가 취소되거나 실패할 때를 대비하기 위함이다.        
  (이 프로젝트에서는 결제까지 진행하지 않으므로 계좌 등록을 하지 않음)
#### 2. 프로젝트 후원
![모든프로젝트](https://user-images.githubusercontent.com/37262132/92992122-6aa3c680-f523-11ea-88dd-5924dde8ccdb.JPG)
    
       - 기본적으로 모든 회원은 프로젝트 후원 가능  
  
![후원1](https://user-images.githubusercontent.com/37262132/92991861-6c6c8a80-f521-11ea-9843-6b1b3915091c.JPG)
![후원2](https://user-images.githubusercontent.com/37262132/92991864-6e364e00-f521-11ea-9297-bcd78f6bdd1b.JPG)
     
       - 상품을 선택하거나 상품을 선택하지 않고 후원할 수 있음
       
![후원3](https://user-images.githubusercontent.com/37262132/92991870-75f5f280-f521-11ea-8a3d-f1079b42b63d.JPG)
      
       - 후원 금액과 요청사항을 입력한 후 후원자 정보 및 배송지 확인    
      
![후원4](https://user-images.githubusercontent.com/37262132/92991871-77271f80-f521-11ea-9136-83d454e035e3.JPG)
      
       - 결제 수단을 선택한 후 후원하기      
      
![후원5](https://user-images.githubusercontent.com/37262132/92991876-80b08780-f521-11ea-88e5-41cec40e3d61.JPG)
    
       - 후원 완료 화면
      
![후원6](https://user-images.githubusercontent.com/37262132/92991993-5e6b3980-f522-11ea-91f8-f53b6e331818.png)
    
       - 후원 완료 후 프로젝트 상세 화면 
    
### 4-2. 사용자 기능
#### 1. 비회원
![회원가입1](https://user-images.githubusercontent.com/37262132/92996901-17913a00-f54a-11ea-80e4-eaf38e0cdee1.JPG)
![회원가입2](https://user-images.githubusercontent.com/37262132/92996902-1b24c100-f54a-11ea-893c-164852f62b06.JPG)
![회원가입3](https://user-images.githubusercontent.com/37262132/92996903-1bbd5780-f54a-11ea-9ad8-be1d958949cf.JPG)

   - 회원가입 

![프로젝트상세보기1](https://user-images.githubusercontent.com/37262132/92996892-08aa8780-f54a-11ea-8d6c-fb660c03b963.JPG)
![프로젝트상세보기2](https://user-images.githubusercontent.com/37262132/92996893-09431e00-f54a-11ea-9bcf-f7447cd779e9.JPG)
![프로젝트상세보기3](https://user-images.githubusercontent.com/37262132/92996894-0a744b00-f54a-11ea-9aea-7c3336165747.JPG)
![프로젝트상세보기4](https://user-images.githubusercontent.com/37262132/92996896-0ba57800-f54a-11ea-9cb1-176cf6d40818.JPG)

   - 프로젝트 검색 / 조회
       
#### 2. 회원
![로그인](https://user-images.githubusercontent.com/37262132/92996808-4fe44880-f549-11ea-8a14-b5c04507e5ef.JPG)
     
   - 로그인 / 로그아웃    
  
![내정보조회](https://user-images.githubusercontent.com/37262132/92996816-61c5eb80-f549-11ea-89c7-c260300e83bb.JPG)
![내정보수정1](https://user-images.githubusercontent.com/37262132/92996820-6ab6bd00-f549-11ea-83e0-8ceb260a572d.JPG)

   - 내정보조회 / 수정 / 탈퇴      

![후원현황](https://user-images.githubusercontent.com/37262132/92996839-96d23e00-f549-11ea-83be-668edaace570.JPG)
![후원현황상세보기](https://user-images.githubusercontent.com/37262132/92996841-989c0180-f549-11ea-8086-a9686edf696e.JPG)
       
   - 내가 올린 프로젝트 후원 현황 보기     
       
![나의프로젝트](https://user-images.githubusercontent.com/37262132/92996860-c5501900-f549-11ea-8c06-89027cfbf4c1.JPG)

   - 내가 올린 프로젝트 목록 보기
       
   - [프로젝트 등록](#1-프로젝트-올리기) / 수정 / 삭제
       
![나의후원현황](https://user-images.githubusercontent.com/37262132/92996864-c719dc80-f549-11ea-8559-66e4bf95eda9.JPG)       
       
   - 내가 후원한 프로젝트 목록 보기    
       
   - [프로젝트 후원](#2-프로젝트-후원) 

![카테고리1](https://user-images.githubusercontent.com/37262132/92996883-ee70a980-f549-11ea-8fab-4958c6448b9f.JPG)
![카테고리2](https://user-images.githubusercontent.com/37262132/92996884-efa1d680-f549-11ea-95b3-7387bf88a061.JPG)

   - 프로젝트 검색 및 조회    
       
![문의](https://user-images.githubusercontent.com/37262132/92996909-2546bf80-f54a-11ea-9b40-604ea8eef23e.JPG)
![문의_답변](https://user-images.githubusercontent.com/37262132/92996910-25df5600-f54a-11ea-992b-3ffeb3ed50e9.JPG)
![문의글답변](https://user-images.githubusercontent.com/37262132/92996912-27108300-f54a-11ea-9fb9-14aef9eaa760.JPG)
       
   - 프로젝트 문의글 작성 / 답변   
       
## 5. 데이터베이스
![WHOWANT_ERD](https://user-images.githubusercontent.com/37262132/92991885-91f99400-f521-11ea-9e37-2c4d59696c43.JPG)
1. ```Account```: 사용자의 정보에 관한 클래스.
       
2. ```Project```: 프로젝트의 정보에 관한 클래스.
       
3. ```Product```: 프로젝트를 구성하는 상품 정보에 관한 클래스.
       
4. ```Category```: 프로젝트의 카테고리에 관한 클래스.
       
5. ```Support```: 후원에 관한 클래스.
       
6. ```Inquiry```: 프로젝트 문의에 관한 클래스.
       
7. ```Answer```: 프로젝트 문의글 답변에 관한 클래스.
       
8. ```Sequence```: Project, Product, Inquiry 시퀀스 관리 클래스
       
## 6. 문제점 및 개선사항
- 프로젝트 마감 시 데이터베이스 변경 처리 미흡
       
- 로그인, 회원가입 시 보안 처리 안됨
       
- 관리자 페이지 없음
    
## 7. 배운 점
- Spring Framework 및 관련 기술들을 이용하여 ```시스템 분석 및 설계부터 구현```까지 개발 과정을 경험      
     
- 자기주도 학습 및 문제해결 능력 함양
       
- 팀 활동 과정을 통해 ```동료들과의 협업 능력```과 리더십 향상
       
