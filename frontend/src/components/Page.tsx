import '@/components/Page.css';
import { useSearchParams, Link } from 'react-router-dom';
import { usePostStore } from '@/store/usePostStore';
import { useEffect } from 'react';

function Page() {
  const [searchParams] = useSearchParams();
  const page = Number(searchParams.get('page') || 1);
  const pageSize = Number(searchParams.get('pageSize') || 10);
  const posts = usePostStore(state => state.posts);
  const getPostsByPage = usePostStore(state => state.getPostsByPage);
  useEffect(() => {
    getPostsByPage(page, pageSize);
  }, [getPostsByPage, page, pageSize]);

  const deletePostById = usePostStore(state => state.deletePostById);

  return (
    <div className="page">
      <table className="bulletin-board-table">
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>삭제</th>
          </tr>
        </thead>
        <tbody>
          {posts.map(p => (
            <tr key={p.id}>
              <td>{p.id}</td>
              <td>
                <Link to={`/edit/${p.id}`} state={{ post: p }}>
                  {p.title}
                </Link>
              </td>
              <td>
                <button
                  onClick={() => {
                    deletePostById(p.id);
                    getPostsByPage(page, pageSize);
                  }}
                >
                  삭제
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Page;
