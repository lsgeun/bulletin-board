import { create } from 'zustand';
import { PostStore } from '@/types/postType';

export const usePostStore = create<PostStore>(set => ({
  posts: [],
  getPostsByPage: (page = 1, pageSize = 10) => {
    fetch(`http://localhost:8080/post?page=${page}&pageSize=${pageSize}`, {
      method: 'GET',
      headers: { ACCEPT: 'application/json' },
    })
      .then(response => {
        if (response.status === 400) {
          return response.json().then(errorData => {
            set({ posts: errorData.posts });
            throw new Error(errorData.message + `: ${errorData.page}`);
          });
        } else if (response.status === 200) {
          return response.json();
        }
      })
      .then(data => {
        set({ posts: data.posts });
        console.log(data.message + `: ${data.page}`);
      })
      .catch(error => {
        console.log(error.message);
      });
  },
  deletePostById: id => {
    fetch(`http://localhost:8080/post/${id}`, {
      method: 'DELETE',
      headers: { ACCEPT: 'application/json' },
    }).then();
  },
}));
