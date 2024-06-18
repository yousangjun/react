import React, { useEffect, useState } from 'react'
import UpdateForm from '../components/board/UpdateForm'
import * as boards from '../apis/boards'
import { useNavigate } from 'react-router-dom'

const UpdateContainer = ({ no }) => {
  const navigate = useNavigate()
  const [board, setBoard] = useState({})
  const [isLoading, setLoading] = useState(false)

  const getBoard = async () => {
    setLoading(true)
    const response = await boards.select(no)
    const data = await response.data        // board 
    console.log(data);
    setBoard(data)
    setLoading(false)
  }

  const onUpdate =  async (no, title, writer, content) => {
    try {
      const response = await boards.update(no, title, writer, content)
      const status = await response.status
      console.log(`게시글 수정 요청 결과 : ${status}`);
      alert("게시글 수정 완료!")

      navigate("/boards")

  } catch (error) {
    console.log(error)
  }
 }

  const onDelete =  async (no) => {
    try {
      const response = await boards.remove(no)
      const status = await response.status
      console.log(`게시글 수정 요청 결과 : ${status}`);
      alert("게시글 삭제 완료!")

      navigate("/boards")

  } catch (error) {
    console.log(error)
  }

 }
  // ? hook
  useEffect(() => {
    getBoard()
  }, [])
  return (
    <>
      <UpdateForm no={no} board={board} onUpdate={onUpdate} onDelete={onDelete} isLoading={isLoading}/>
    </>
  )
}

export default UpdateContainer