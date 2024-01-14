// transaction.model.ts
import { Category } from './category.model';

export class Transaction {
  id!: number;
  value!: number;
  method!: string;
  description!: string;
  category!: Category;
  cardId!: number;
  creationDate!: string;
  deletionDate!: string | null;

  constructor(data: Partial<Transaction> = {}) {
    Object.assign(this, data);
    this.category = new Category(data.category);
  }
}
