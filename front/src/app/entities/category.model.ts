// category.model.ts
export class Category {
    id!: number;
    description!: string;
  
    constructor(data: Partial<Category> = {}) {
      Object.assign(this, data);
    }

    /*constructor(number id, string description){
        this.id = id;
        this.description = description;
    }*/
  }
  