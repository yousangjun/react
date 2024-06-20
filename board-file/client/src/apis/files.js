import axios from 'axios'

// 업로드
export const upload = (formData, headers) => axios.post(`/files`, formData, headers)

// 다운로드 요청
export const download = (no) => axios.get(`/files/${no}`,{responseType: 'blob'})

// 파일 삭제
export const remove = (no) => axios.delete(`/files/${no}`)

// 
export const removeFiles = (fileNos) => axios.delete(`/files?no=${fileNos}`)