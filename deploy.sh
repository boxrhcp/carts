sh scripts/build.sh

docker tag weaveworksdemos/carts:test eu.gcr.io/optimum-mode-272714/carts

docker push eu.gcr.io/optimum-mode-272714/carts