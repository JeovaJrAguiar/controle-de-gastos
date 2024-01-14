import { Injectable } from '@angular/core';
import { CanActivateFn } from '@angular/router';
import { StorageService } from './storage/storage.service';

export const authGuard: CanActivateFn = (route) => {
  return false
};
