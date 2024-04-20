# :iphone: 사과마켓 구현 앱

<br/>

<p align="center">
   <figcaption align="center"></figcaption>
</p>

<br/>

## :tada: 배운 지식 혹은 필요한 지식
- ViewBinding
- ListView, GridView, CustomView
- RecyclerView
- Dialog
- Notification
- Fragment

<br/>

## :hammer: 메인 페이지 만들기

- [X]  디자인 및 화면 구성을 최대한 동일하게 구현 (사이즈 및 여백도 최대한 맞춤 ✨)
- [X]  상품 데이터는 ```Dummy Data```를 사용, 싱글톤으로 구현
- [X]  ```RecyclerViewer```를 이용해 리스트 화면 제작
- [X]  상단 툴바를 제거하고 ```Full Screen``` 화면으로 세팅 (상태바(시간/배터리 표시하는 최상단바)는 남김)
- [X]  상품 이미지는 모서리를 라운드 처리 : clipToOutline
- [X]  상품 이름은 최대 두 줄으로 설정, 그래도 넘어가면 뒷 부분에 …으로 처리 : maxLines, ellipsize
- [X]  뒤로가기(BACK)버튼 클릭시 종료하시겠습니까? [확인][취소] ```Dialog```를 출력
- [X]  상단 종모양 아이콘을 눌렀을 때 실행되는 ```Notification```을 구현
- [X]  상품 가격은 1000단위로 콤마(,) 처리 : DecimalFormat
- [X]  상품 아이템들 사이에 회색 라인을 추가해서 구분 : addItemDecoration(DividerItemDecoration), View로 구현하는 것과의 차이점?
- [X]  상품 선택시 아래 상품 상세 페이지로 이동
- [X]  상품 상세페이지 이동시 ```intent```로 객체를 전달 (```Parcelize``` 사용)

<br/>
 
## :hammer: 상품 상세페이지 만들기

- [X]  디자인 및 화면 구성을 최대한 동일하게 구현 (사이즈 및 여백도 최대한 맞춤 ✨) 
- [X]  메인화면에서 전달받은 데이터로 판매자, 주소, 아이템, 글내용, 가격등을 화면에 표시
- [X]  하단 가격표시 레이아웃을 제외하고 전체화면은 스크롤 구현 : ScrollView
- [X]  상단 < 버튼을 누르면 상세 화면은 종료되고 메인화면으로 돌아감 : finish()

<br/>

## :hammer: 스크롤 상단 이동 기능 구현

- [ ]  스크롤을 최상단으로 이동시키는 ```Floating Button``` 기능 추가
- [ ]  플로팅 버튼은 스크롤을 아래로 내릴 때 나타나며, 스크롤이 최상단일때 사라짐
- [ ]  플로팅 버튼을 누르면 스크롤을 최상단으로 이동
- [ ]  플로팅 버튼은 나타나고 사라질때 fade 효과
- [ ]  플로팅 버튼을 클릭하면(pressed) 아이콘 색이 변경

<br/>

## :hammer: 상품 삭제 기능 구현

- [ ]  상품을 롱클릭 했을때 삭제 여부를 묻는 ```Dialog```를 띄움
- [ ]  ```Dialog```에서 확인을 선택 시 해당 항목을 삭제하고 리스트를 업데이트

<br/>

## :hammer: 좋아요 처리 기능 구현

- [ ]  상품 상세 화면에서 좋아요 선택시 아이콘 변경 및 ```Snackbar``` 메세지 표시
- [ ]  메인 화면으로 돌아오면 해당 상품에 좋아요 표시 및 좋아요 카운트 +1
- [ ]  상세 화면에서 좋아요 해제시 이전 상태로 되돌림

<br/>

## :hammer: 개인적인 구현
- [ ]  Fragment를 이용한 데이터 값 넘기기
- [X]  mipmap 수정
- [X]  알림 권한 부여 확인

<br/>


