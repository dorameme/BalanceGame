# BalanceGame
## 제가 좋아하는 밸런스게임을 여러분도 같이해요
[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fgjbae1212%2Fhit-counter&count_bg=%23000000&title_bg=%23FF0000&icon=&icon_color=%23111010&title=hits&edge_flat=false)](https://hits.seeyoufarm.com)

개발기간: 2023-9-12 ~ 현재     
배포주소:

목차) 

## -프로젝트 생성전에 준비물-

>### 1. 프로그래밍 언어 
1. 요구사항: 익숙하며 쓰기쉬운 언어 필요 
2. 2.선택:java/ jdk11
3. 이유: 익숙한 프로그래밍 언어인 자바를 선택했다. / LTS버전이라 오래동안 사용가능하며 초기버전이 아니라 안정적인 11버전을 선택
>### 2. 빌드관리도구(build tool)
1. 요구사항: 외부라이브러리 관리도 해주고 편하고 빠른걸로 선택
2. 선택:gradle
3. 이유: 외부라이브러리 관리도 되고 maven보다 가독성이 우세하고
빌드와 테스트 실행결과가 더 빠른 gradle선택!

>### 3. DataBase
1. 요구사항:모든 스키마가 고정된상태, 서버의 작동 유무 없이 데이터유지, 복잡하지 않은 데이터베이스
2. 선택:MySQL
3. 이유:
스키마가 고정되어있으므로 RDB를 선택!
그중 disk-based DB 이고 간단한 데이터베이스인 MySQL 선택

>### 4. IDE
1. 요구사항:언어로 자바를 지원하고, 무료이며, 프로젝트 규모가 크지않아 사용이 편리한 간단한 ide가 필요.
2. 선택:intellij-IDEA
3. 이유: 원래 자주쓰던 IDE이고  자바를 지원하며 자동완성기능이 잘되어있어 사용이 편리하고 단일프로젝트로 쓰기 좋기도 하다.

>### 5. API 테스트 도구
1. 요구사항:	무료여야 한다 사용하기 간편해야함
2. 선택:postman
3. 이유: 무료.  직관적이고 사용하기 좋다.

>### 6. 버전관리 프로그램
1. 요구사항:익숙하여 쉽게 사용가능하고 중앙집중식 보단 분산형 버전관리 시스템이 좋다.
2. 선택: git
3. 이유: svn같은 경우 중앙집중형 시스템이라 git에 비해 느리고 mercurial는 러닝커브가 생김
