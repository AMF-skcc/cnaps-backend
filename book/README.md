# 도서 서비스 (Member)
> DDD/Aggregate 패턴으로 구현 됨
## 개요
### 포함하는 Bounded Context
- 도서 카테고리
- 도서

### 주요 기능
- 도서 카테고리 등록 / 삭제 (도서 카테고리는 상위 카테고리, 하위 카테고리로 분류됨)
- 도서 등록 / 삭제

### 마이크로서비스 구성
- 도서 카테고리와 도서의 기능을 하나의 서비스에서 구현하기로 결정하였다.
- 두 Context간 응집도가 높다고 판단되어 하나의 서비스에 구현한다.

## 주요 API

|no.| API URI | 방식 | 설명 | 비고 |
|:-:| :------ | :-: | :-- | :-- |
| 1	| /api/book-category      | GET    | 도서 카테고리 목록 조회 | size, page 주어짐 |


## 주요 이벤트
### 발신 이벤트
|no.| Evnet 명 | 발신 데이터 | 설명 |
|:-:| :------ | :-: | :-- |
| 1 |  | |  |

### 수신 이벤트
