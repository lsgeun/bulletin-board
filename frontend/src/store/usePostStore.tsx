import { create } from 'zustand';
import { persist } from 'zustand/middleware';
import { PostStore } from '@/types/postType';
import cloneDeep from 'lodash/cloneDeep';

export const usePostStore = create<PostStore>((set, get) => ({
  page: 1,
  setPage: page => {
    set({ page });
  },
  pageSize: 10,
  setPageSize: pageSize => {
    set({ pageSize });
  },
  posts: [],
  getPostById: (id = 1) => {},
  getPostsByPage: async (page = 1, pageSize = 10) => {
    const previousPosts = cloneDeep(get().posts);

    try {
      const response = await fetch(`http://localhost:8080/post?page=${page}&pageSize=${pageSize}`, {
        method: 'GET',
        headers: { ACCEPT: 'application/json' },
      });
      const data = await response.json();

      if (response.status === 200) {
        set({ posts: data.posts });
        console.log(data.message + ` page: ${data.page}`);
      } else if (response.status === 400) {
        set({ posts: data.posts });
        throw new Error(data.message + ` page: ${data.page}`);
      } else if (response.status === 500) {
        throw new Error(data.message);
      } else {
        throw new Error('알 수 없는 응답 상태');
      }
    } catch (error) {
      set({ posts: previousPosts });
      console.log(error.message);
    }
  },
  deletePostById: async id => {
    try {
      const response = await fetch(`http://localhost:8080/post/${id}`, {
        method: 'DELETE',
        headers: { ACCEPT: 'application/json' },
      });
      const data = await response.json();

      if (response.status === 200) {
        console.log(data.message);
      } else if (response.status === 404) {
        throw new Error(data.message);
      } else if (response.status === 500) {
        throw new Error(data.message);
      } else {
        throw new Error('알 수 없는 응답 상태');
      }
    } catch (error) {
      console.log(error.message);
    }
  },
}));
