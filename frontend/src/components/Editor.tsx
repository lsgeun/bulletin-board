import '@/components/Editor.css';
import { useParams, useNavigate } from 'react-router-dom';
import { useState } from 'react';
import { usePostStore } from '@/store/usePostStore';

function Editor() {
  const { id } = useParams();
  const postId = Number(id);
  const posts = usePostStore(state => state.posts);
  const currentPost = posts.find(p => p.id === postId);
  const [postTitle, setPostTitle] = useState(currentPost.title);
  const [postContent, setPostContent] = useState(currentPost.content);
  const navigate = useNavigate();

  return (
    <div className="editor">
      <h1>Editor {postId}</h1>
      <nav>
        <button
          onClick={() => {
            navigate('/');
          }}
        >
          홈으로
        </button>
        <button onClick={() => {
          navigate(-1);
        }}>뒤로</button>
        <div>
          <h1>제목</h1>
          <textarea value={postTitle} onChange={e => setPostTitle(e.target.value)}></textarea>
        </div>
        <div>
          <h1>내용</h1>
          <textarea value={postContent} onChange={e => setPostContent(e.target.value)}></textarea>
        </div>
        <div>
          <button>수정</button>
          <button>삭제</button>
        </div>
      </nav>
    </div>
  );
}

export default Editor;
