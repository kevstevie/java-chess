# 기능 요구 사항

---

## 체스판 초기화

- [ ] 8x8 크기의 보드 생성
- [ ] 피스 위치 초기화
    - [ ] 검정색 피스 초기화
    - [ ] 흰색 피스 초기화

- [X] Piece 경로 계산
    - [X] 퀸
    - [X] 킹
    - [X] 룩
    - [X] 비숍
    - [X] 나이트
    - [X] 폰

- [X] Piece 이동 가능 계산
    - [X] 퀸
    - [X] 킹
    - [X] 룩
    - [X] 비숍
    - [X] 나이트
    - [X] 폰

- [ ] Square
    - [ ] 인스턴스로 Piece를 가짐
- [ ] Rank
    - [ ] Square의 일급 컬렉션
- [ ] Board
    - [ ] Rank의 일급 컬렉션
    - [ ] source와 target이 같은 색이면 예외 발생

## 출력

- [ ] 게임 시작을 입력받는다
- [ ] 게임 종료를 입력받는다
- [ ] 보드 출력
    - [ ] 검은색 피스는 대문자로 출력
    - [ ] 하얀색 피스는 소문자로 출력
