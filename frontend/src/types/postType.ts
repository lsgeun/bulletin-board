export type Post = {
  id: number;
  title: string;
  content: string;
};

export type PostStore = {
  page: number;
  setPage: (page: number) => void;
  pageSize: number;
  setPageSize: (pageSize: number) => void;
  posts: Post[];
  getPostById: (id: number) => void;
  getPostsByPage: (page?: number, pageSize?: number) => void;
  deletePostById: (id: number) => void;
};
