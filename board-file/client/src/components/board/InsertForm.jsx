import React, { useState } from 'react'
import {Link} from 'react-router-dom'
import styles from '../board/css/insert.module.css'

const InsertForm = ({ onInsert }) => {

  // state
  const [title, setTitle] = useState('')
  const [writer, setWriter] = useState('')
  const [content, setContent] = useState('')
  const [files, setFiles] = useState(null)    // files state 추가

  // 함수
  const handleChangeTitle = (e) => {
    setTitle(e.target.value)
  }
  const handleChangeWriter = (e) => {
    setWriter(e.target.value)
  }
  const handleChangeContent = (e) => {
    setContent(e.target.value)
  }
  // ✅ 파일 핸들러 추가
  const handleChangeFile = (e) => {
    setFiles(e.target.files)
  }

  const onSubmit = () => {   
    // 유효성 검사 ✅
    // ...

    // 파일 업로드에서는 
    // Content - Type : application/json -> multipart/form-data
    const formData = new FormData()
    formData.append('title', title)
    formData.append('writer', writer)
    formData.append('content', content)

    if(files) {
      for ( let i = 0; i< files.length; i++){
        const file = files[i];
        formData.append('files',file)
      }
    }

    const headers = {
      'Content-Type' : 'multipart/form-data'
    }

    // onInsert(title,writer,content)   // json
    onInsert(formData, headers)         // formData
  }

  return (
    <div className='container'>
      <h1 className='title'>게시글 등록</h1>
      <table className={styles.table}>
        <tbody>
          <tr>
            <td>제목</td>
            <td>
              {
                // css module 의 클래스 선택자는 카멜케이스로 쓰는 것이 관례
                // 카멜 케이스 : styles.formInput
                // 케밥 케이스 : styles['form-input']
              }
              <input type="text" 
                     value={title}
                     className={styles['form-input']}
                     onChange={handleChangeTitle}/>
            </td>
          </tr>
          <tr>
            <td>작성자</td>
            <td>
              <input type="text" 
                      value={writer}
                      className={styles['form-input']}
                      onChange={handleChangeWriter}/>
            </td>
          </tr>
          <tr>
            <td colSpan={2}>내용</td>
          </tr>
          <tr>
            <td colSpan={2}>
              <textarea cols="40" rows="10"
                        value={content}
                        className={styles['form-input']}
                        onChange={handleChangeContent}></textarea>
            </td>
          </tr>
          <tr>
            <td>파일</td>
            <td>
              <input type="file" multiple onChange={handleChangeFile}/>
            </td>
          </tr>
        </tbody>
      </table>
      <div className="btn-box">
        <Link to="/boards" className='btn'>목록</Link>
        <button className='btn' onClick={ onSubmit }>등록</button>
      </div>
    </div>
  )
}

export default InsertForm