# Coffee-Chat-App

---

- Coffee-Chat-App 은 Mentor 와 Mentee 의 채팅을 도와주는 App 입니다.
- Coffee-Chat-App 은 Server Side Repository 입니다.

<br />

## Git Flow

---

- Main / Develop / Issues/*
    - main : Product 에 배포되는 기준 브랜치
    - develop : Dev 서버에 배포되는 기준 브랜치
    - issues/* : 발행된 이슈 번호를 브랜치명에 넘버링


<br />

- Git Flow 절차
    - 개발하고자 하는 개발 내용에 대해 GitHub 레파지토리에서 Issue 를 발행
        - develop 브랜치를 기준으로 issues/* 을 생성한다.
        - Issues 는 해당되는 마일스톤과 프로젝트에 반영하도록 한다.
    - 개발이 완료되면 Pull-Request 를 생성 후 리뷰어에게 리뷰를 요청
    - 1주일에 1번 개발팀 정기회의 진행 후 Pull-Request 리뷰를 통해 Develop 으로 Merge 진행

    <br />

- Git Commit Convention
    - feat : 새로운 기능
    - fix : 버그 수정
    - docs : 문서 변경
    - style : 포맷팅, 코드 변경 없음
    - refactor : Refactoring code
    - test : 테스트 수정/추가
    - chore : 빌드 작업, 패키지 관리자 구성, 파일추가 등 업데이트

<br />

- Issues 에 대한 Git Commit 은 연결된 해당 이슈를 선언한 후 Convention 을 반영하도록 한다.
    - [#{issues_number}] chore : 커밋 내용



<br />