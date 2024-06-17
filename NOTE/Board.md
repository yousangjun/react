FrontEnd

1.Containers

- 게시글 목록 - ListContainer
- 게시글 등록 - InsertContainer
- 게시글 조회 - ReadContainer
- 게시글 수정 - UpdateContainer

2.Components

    board
        - List
        - Read
        - InsertForm
        - UpdateForm

3.pages

    1.board
        - List
        - Read
        - Insert
        - Update
    2.Home

4.apis
    - boards.js


axios 라이브러리 설치
    npm install axios

axios 사용 방법
    -import
    -> import axios from 'axios';
    -[GET]
    -> axios.get("경로")
    -[PUT]
    -> axios.put("경로",{데이터})
    -[POST]
    -> axios.post("경로", {데이터})
    -[DELETE]
    -> axios.delete("경로")