package com.aloha.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aloha.server.dto.Board;
import com.aloha.server.dto.Files;
import com.aloha.server.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private FileService fileService;

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<Board> list() throws Exception {

        List<Board> boardList = boardMapper.list();
        return boardList;
    }

    @Override
    public Board select(int no) throws Exception {

        Board boardList = boardMapper.select(no);

        return boardList;
    }

    @Override
    public int delete(int no) throws Exception {

        int result = boardMapper.delete(no);

        Files file = new Files();
        file.setParentTable("board");
        file.setParentNo(no);
        List<Files> deleteFileList = fileService.listByParent(file);


        for (Files deleteFile : deleteFileList) {
            fileService.delete(deleteFile.getNo());
        }
        return result;
    }

    @Override
    public Board insert(Board board) throws Exception {
        int result = boardMapper.insert(board);
        log.info("result : " + result);
        int newNo = board.getNo();
        Board newBoard = boardMapper.select(newNo);

        int uploadResult = uploadFile(newBoard);
        log.info("파일 " + uploadResult + "개 업로드 되었습니다.");

        return newBoard;
    }

    @Override
    public int update(Board board) throws Exception {
        int result = boardMapper.update(board);

        // 파일 업로드
        int uploadResult = uploadFile(board);
        log.info("파일 " + uploadResult + "개 업로드 되었습니다.");

        return result;
    }

    public int uploadFile(Board board) throws Exception {
        // 파일 업로드
        Files fileInfo = new Files();
        String parentTable = "board";
        fileInfo.setParentTable(parentTable);
        fileInfo.setParentNo(board.getNo());
        List<MultipartFile> fileList = board.getFiles();

        if (fileList == null || fileList.isEmpty()) {
            log.info("첨부된 파일이 없습니다");
            return 0;
        }

        List<Files> uploadedFileList = fileService.uploadFiles(fileInfo, fileList);
        if (uploadedFileList == null || uploadedFileList.isEmpty()) {
            log.info("파일 업로드 실패");
            return 0;
        } 
        else {
            log.info("파일 업로드 성공");
            log.info(uploadedFileList.toString());
            return uploadedFileList.size();
        }
    }

}
