export type Post = {
  id: number;
  title: string;
  content: string;
};

export type PostStore = {
  posts: Post[];
  getPostsByPage: (page?: number, pageSize?: number) => void;
  deletePostById: (id: number) => void;
};
